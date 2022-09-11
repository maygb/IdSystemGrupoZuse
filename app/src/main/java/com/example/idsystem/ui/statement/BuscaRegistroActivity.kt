package com.example.idsystem.ui.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.idsystem.data.RetrofitFactory
import com.example.idsystem.databinding.ActivityBuscaRegistroBinding
import com.example.idsystem.domain.Cadastro
import com.example.idsystem.domain.Pessoas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscaRegistroActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityBuscaRegistroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBuscar.setOnClickListener{
            val cpfRecuperado = binding.etPdCpf.text.toString()
            val cpf = Cadastro(cpfRecuperado)
            val progress = binding.progressBar
            val call = RetrofitFactory().retrofitService().findCpf(cpfRecuperado)

            progress.visibility = View.VISIBLE

            call.enqueue(object : Call<Pessoas> {

                override fun onResponse(call: Call<Pessoas>, response: Response<Pessoas>) {

                    response.body()?.let {
                        Log.i("CPF", it.toString())
                        Toast.makeText(this@BuscaRegistroActivity, it.toString(), Toast.LENGTH_LONG).show()
                        progress.visibility = View.INVISIBLE
                    } ?: Toast.makeText(this@BuscaRegistroActivity, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(call: Call<Pessoas>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progress.visibility = View.INVISIBLE
                }
            })

            val intent = Intent(this, BuscaActivity::class.java).apply{
                putExtra(BuscaActivity.CADASTRO_DESAPARECIDO, cpf)
            }
            startActivity(intent)
        }
    }
}