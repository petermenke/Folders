package com.petermenke.folders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.petermenke.folders.home.FolderListAdapter
import com.petermenke.folders.util.ShareUtil

private const val TAG = "MyActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: FolderListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        // Init
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = FolderListAdapter(arrayOf("alpha", "beta", "gamma"))
        linearLayoutManager = LinearLayoutManager(this)

        // Setup list
        val recyclerView: RecyclerView = findViewById(R.id.folders_list_recycler)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter


        // Intent stuff
        if (intent?.action == Intent.ACTION_SEND) {
            if (intent.type?.startsWith("text/") == true) {
                val url: String = intent.getStringExtra("android.intent.extra.TEXT").toString()
                // intent.getStringExtra();
                Log.i(TAG, url)
            }
        }

        ShareUtil.publishMemeShareShortcuts(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ShareUtil.unPublishMemeShareShortcuts(this)
    }
}