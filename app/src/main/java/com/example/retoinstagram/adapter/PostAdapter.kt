package com.example.retoinstagram.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retoinstagram.Post
import com.example.retoinstagram.R

class PostAdapter(private val allPostList:List<Post>) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  PostViewHolder(layoutInflater.inflate(R.layout.item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = allPostList.size

}