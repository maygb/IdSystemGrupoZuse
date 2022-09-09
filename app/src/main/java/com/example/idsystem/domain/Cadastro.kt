package com.example.idsystem.domain

data class Cadastro(
    val id: Int,
    val nome: String,
    val cpf: String,
    val telefone: String,
    val endereco: String,
    val tipoSanguineo: String,
    val alergia: String,
    val doencaCronica: String,
    val nomeContatoEmergencia: String,
    val telContatoEmergencia: String,
    val observacoes: String
)
