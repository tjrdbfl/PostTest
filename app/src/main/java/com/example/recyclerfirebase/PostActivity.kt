package com.example.recyclerfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerfirebase.databinding.ActivityPostBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database = Firebase.database("https://mobliappteamproject-default-rtdb.asia-southeast1.firebasedatabase.app")
        var postsRef = database.reference.child("posts")

        binding.submitBtn.setOnClickListener {
            postsRef.child(binding.titleEt.text.toString()).setValue(binding.innerEt.text.toString())
            finish()
        }
    }
}