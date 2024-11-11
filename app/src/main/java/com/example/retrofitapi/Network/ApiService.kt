package com.example.retrofitapi.Network

import com.example.retrofitapi.Model.Data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getAllUsers(): Call<Data>
}