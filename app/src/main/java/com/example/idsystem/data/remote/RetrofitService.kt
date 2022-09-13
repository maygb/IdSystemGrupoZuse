package com.example.idsystem.data.remote

import com.example.idsystem.domain.Cadastro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("pessoa/cadastro/{cpf}")
    fun findCpf(@Path("cpf") CPF:String):Call<Cadastro>


}
