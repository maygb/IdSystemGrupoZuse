package com.example.idsystem.data


import android.util.Log
import androidx.lifecycle.liveData
import com.example.idsystem.data.remote.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

object IdSystemRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    fun findCadastroPessoaDesaparecida(cpf: String) = liveData {
        emit(State.Wait)
        try{
            emit(State.Success(data = restApi.findCpf(cpf)))
        } catch (e: Exception) {
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}