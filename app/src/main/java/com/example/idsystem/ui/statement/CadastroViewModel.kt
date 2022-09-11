package com.example.idsystem.ui.statement

import androidx.lifecycle.ViewModel
import com.example.idsystem.data.IdSystemRepository
import com.example.idsystem.data.RetrofitFactory

class CadastroViewModel : ViewModel() {

    fun findCadastro(cpf: String) =
        IdSystemRepository.findCadastroPessoaDesaparecida(cpf)
}