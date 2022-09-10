package com.example.idsystem.data

import com.example.idsystem.data.remote.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    val URL: String = "http://10.0.2.2:8080/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService(): RetrofitService{
        return retrofitFactory.create(RetrofitService::class.java)
    }
}