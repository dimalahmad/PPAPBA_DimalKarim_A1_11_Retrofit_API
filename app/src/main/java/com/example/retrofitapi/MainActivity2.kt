package com.example.retrofitapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.retrofitapi.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
        val avatar = intent.getStringExtra("Avatar")

        with(binding) {
            tvName.text = name
            tvEmail.text = email
            Glide.with(imgAvatar.context)
                .load(avatar)
                .into(imgAvatar)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
