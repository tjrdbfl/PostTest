package com.example.recyclerfirebase

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerfirebase.databinding.PostListsBinding

class PostAdapter(val datas: MutableMap<String, String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var m_parent: ViewGroup


    class PostViewHolder(val binding: PostListsBinding): RecyclerView.ViewHolder(binding.root)
    override fun getItemCount(): Int = datas.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerView.ViewHolder {
        m_parent = parent
        return PostViewHolder(PostListsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as PostViewHolder).binding
        val selectedPost = datas.toList()[position]
        binding.postTitle.text =   selectedPost.first;
        binding.itemRoot.setOnClickListener{
            val intent = Intent(m_parent.context, ReadPost::class.java)
            intent.putExtra("제목", selectedPost.first);
            intent.putExtra("내용", selectedPost.second);
            m_parent.context.startActivity(intent)
        }

    }

}