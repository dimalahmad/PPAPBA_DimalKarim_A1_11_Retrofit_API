package com.example.retrofitapi

import UserAdapter
import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapi.Model.Data
import com.example.retrofitapi.Model.Users
import com.example.retrofitapi.Network.ApiClient
import com.example.retrofitapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val users = response.body()?.data ?: emptyList()
                val adapter = UserAdapter(users){ it ->
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("Name", it.firstName)
                    intent.putExtra("Email", it.email)
                    intent.putExtra("Avatar", it.avatar)
                    startActivity(intent)
                }
                Log.d("API Response", "Users: $users")
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}