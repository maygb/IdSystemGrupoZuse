package com.example.idsystem.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.idsystem.ui.statement.BuscaActivity
import com.example.idsystem.ui.statement.BuscaRegistroActivity
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

}