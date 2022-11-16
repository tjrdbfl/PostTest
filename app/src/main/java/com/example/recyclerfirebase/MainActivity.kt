package com.example.recyclerfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.recyclerfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
        var postsRef = database.reference.child("posts")
        val titles = mutableMapOf<String, String>();
        postsRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //Get map of users in datasnapshot

                val posts = dataSnapshot.children
                for(i in posts)
                    if(!titles.containsKey(i.key.toString()))
                        titles[i.key.toString()] = i.value.toString()
                (binding.recyclerView.adapter as PostAdapter).notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                //handle databaseError
            }
        });
        binding.fabAddPost.setOnClickListener{
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = PostAdapter(titles)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL)
        )

    }


        //myRef.

}