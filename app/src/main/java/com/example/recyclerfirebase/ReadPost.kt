package com.example.recyclerfirebase

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.recyclerfirebase.databinding.ActivityReadPostBinding

class ReadPost : AppCompatActivity() {

    private lateinit var binding: ActivityReadPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReadPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.titleTv.text = intent.getStringExtra("제목")
        binding.innerTv.text = intent.getStringExtra("내용")
        binding.backBtn.setOnClickListener { finish() }
    }

}