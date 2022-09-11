package com.example.idsystem.ui.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.idsystem.data.State
import com.example.idsystem.databinding.ActivityBuscaBinding
import com.example.idsystem.domain.Cadastro
import com.example.idsystem.ui.welcome.WelcomeActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalArgumentException

class BuscaActivity : AppCompatActivity() {

    companion object{
        const val CADASTRO_DESAPARECIDO = "com.example.idsystem.ui.statement.CADASTRO_DESAPARECIDO"
    }

    private val binding by lazy{
        ActivityBuscaBinding.inflate(layoutInflater)
    }

    private val cadastro by lazy {
        intent.getParcelableExtra<Cadastro>(CADASTRO_DESAPARECIDO) ?: throw IllegalArgumentException()
    }

    private val viewModel by viewModels<CadastroViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

          findCadastro()
    }

     private fun findCadastro() {
         viewModel.findCadastro(cadastro.cpf).observe(this) { state ->
             when (state) {
                 is State.Success -> {
                     binding.rvBankStatement.adapter = state.data?.let { CadastroStatementAdapters(it) }
                 }
                 is State.Error -> {
                     state.message?.let {Snackbar.make(binding.rvBankStatement, it, Snackbar.LENGTH_LONG).show() }

                 }
                 State.Wait -> binding.rvBankStatement.scrollState
             }
         }
     }

    fun voltarInicio(view: View){
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
}