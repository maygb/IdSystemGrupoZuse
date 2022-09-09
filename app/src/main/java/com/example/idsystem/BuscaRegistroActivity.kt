package com.example.idsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BuscaRegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca_registro)
    }

    fun buscarRegistro(view: View){
        val intent = Intent(this, BuscaActivity::class.java)
        startActivity(intent)
    }
}