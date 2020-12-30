package com.petermenke.folders.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.petermenke.folders.R


class FolderListItemViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    var icon: ImageView? = null
    var text: TextView? = null
    var secondary: TextView? = null

    init {
        icon = itemView.findViewById(R.id.folder_icon)
        text = itemView.findViewById(R.id.folder_name)
        secondary = itemView.findViewById(R.id.folder_second_line)
    }

    override fun onClick(view: View?) {
        Log.d("RecyclerView", "CLICK!")
    }
}