package com.example.idsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.idsystem.data.RetrofitFactory
import com.example.idsystem.domain.Cadastro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscaRegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca_registro)

        val pesquisaCPF: Button = findViewById(R.id.btn_buscar)
        val cpf: EditText = findViewById(R.id.et_pd_nome)
        val progress_bar: ProgressBar = findViewById(R.id.progress_bar)

        pesquisaCPF.setOnClickListener{
            val call = RetrofitFactory().retrofitService().findCpf(cpf.text.toString())

            progress_bar.visibility = View.VISIBLE

            call.enqueue(object : Callback<Cadastro> {

                override fun onResponse(call: Call<Cadastro>, response: Response<Cadastro>) {

                    response.body()?.let {
                        Log.i("CPF", it.toString())
                        Toast.makeText(this@BuscaRegistroActivity, it.toString(), Toast.LENGTH_LONG).show()
                        progress_bar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(this@BuscaRegistroActivity, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(call: Call<Cadastro>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    progress_bar.visibility = View.INVISIBLE
                }
            })
        }

        fun buscarRegistro(view: View){
            val intent = Intent(this, BuscaActivity::class.java)
            startActivity(intent)
        }
    }
}