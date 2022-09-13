package com.example.idsystem.domain

data class Cadastro(
    val nome: String,
    val cpf: String,
    val nomeContatoEmergencia: String,
    val telContatoEmergencia: String,
    val observacoes: String
)
