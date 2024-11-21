package com.example.assignment

import com.example.assignment.DataClasses.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val retrofit = Retrofit.Builder().baseUrl("http://52.25.229.242:8000/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)

interface ApiService{
@GET("food_info/")
suspend fun getData():Data
}