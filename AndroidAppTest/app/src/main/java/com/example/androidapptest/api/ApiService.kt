package com.example.androidapptest.api

import com.example.androidapptest.DataModel.Person
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("human/") // Endpoint for fetching humans
    fun getHumans(): Call<List<Person>>
}