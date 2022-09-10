package com.example.idsystem.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.idsystem.data.remote.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object IdSystemRepository {
    private val restApi = Retrofit.Builder()
        .baseUrl("http://localhost:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IdSystemRepository::class.java)


}