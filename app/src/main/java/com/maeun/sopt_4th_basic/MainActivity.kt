package com.maeun.sopt_4th_basic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.maeun.sopt_4th_basic.get.GetBoardResponse
import com.maeun.sopt_4th_basic.get.GetBoardResponseData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService
    lateinit var boardAdapter : BoardAdapter
    lateinit var boardItems : ArrayList<GetBoardResponseData>
    lateinit var requestManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkService = ApplicationController.instance.networkSerVice
        requestManager = Glide.with(this)
        main_board_rv.layoutManager = LinearLayoutManager(this)

        main_write_btn.setOnClickListener{
            startActivity(Intent(applicationContext, BoardActivity::class.java))
        }

        val getBoardResponse = networkService.getContent()
        getBoardResponse.enqueue(object : Callback<GetBoardResponse> {
            override fun onFailure(call: Call<GetBoardResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetBoardResponse>?, response: Response<GetBoardResponse>?) {
                if (response!!.isSuccessful) {
                    boardItems = response.body().data
                    boardAdapter = BoardAdapter(boardItems, requestManager)
                    main_board_rv.adapter = boardAdapter
                }
            }
        })
    }
}
