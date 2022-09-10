package com.example.idsystem.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.idsystem.BuscaActivity
import com.example.idsystem.BuscaRegistroActivity
import com.example.idsystem.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun buscarPessoas(view: View){
        val intent = Intent(this, BuscaRegistroActivity::class.java)
        startActivity(intent)
    }

    fun buscarRegistro(view: View){
        val intent = Intent(this, BuscaActivity::class.java)
        startActivity(intent)
    }
}