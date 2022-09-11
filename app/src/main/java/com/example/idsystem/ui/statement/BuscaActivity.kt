package com.example.idsystem.ui.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.idsystem.R
import com.example.idsystem.data.State
import com.example.idsystem.databinding.ActivityBuscaBinding
import com.example.idsystem.databinding.ActivityBuscaRegistroBinding
import com.example.idsystem.domain.Cadastro
import com.example.idsystem.ui.welcome.WelcomeActivity
import java.lang.IllegalArgumentException

class BuscaActivity : AppCompatActivity() {

    companion object{
        const val CADASTRO_DESAPARECIDO = "com.example.idsystem.ui.statement.CADASTRO_DESAPARECIDO"
    }

    private val binding by lazy{
        ActivityBuscaBinding.inflate(layoutInflater)
    }

    private val cpf by lazy {
        intent.getParcelableExtra<Cadastro>(CADASTRO_DESAPARECIDO) ?: throw IllegalArgumentException()
    }

    private val viewModel by viewModels<CadastroViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("TESTE", "Chegou o ID: ${cpf}")

        //findCadastro()
    }

/*    private fun findCadastro() {
        viewModel.findCadastro().observe(this) { state ->
            when(state){
                is State.Success -> {
                    binding.rv
                }
                is State.Error -> TODO()
                State.Wait -> TODO()
            }

        }
    }*/

    fun voltarInicio(view: View){
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
}