package com.maeun.sopt_4th_basic

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class BoardViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var boardProfile : ImageView = itemView!!.findViewById(R.id.board_item_profile) as ImageView
    var boardId : TextView = itemView!!.findViewById(R.id.board_item_id) as TextView
    var boardTitle : TextView = itemView!!.findViewById(R.id.board_item_title) as TextView
    var boardTime : TextView = itemView!!.findViewById(R.id.board_item_time) as TextView
    var boardContent : TextView = itemView!!.findViewById(R.id.board_item_content) as TextView
}