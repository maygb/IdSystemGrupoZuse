package com.example.idsystem.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cadastro(
    val cpf: String
) :Parcelable
