package com.petermenke.folders.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petermenke.folders.R

class FolderListAdapter(folders: Array<String>) : RecyclerView.Adapter<FolderListItemViewHolder>()  {
    val folders: Array<String> = folders;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.folder_list_item, parent, false)
        return FolderListItemViewHolder(view);

    }

    override fun getItemCount(): Int {
        return folders.size
    }

    override fun onBindViewHolder(holder: FolderListItemViewHolder, position: Int) {
        holder.text?.text = folders[position]
    }
}