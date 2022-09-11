package com.example.idsystem.ui.statement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idsystem.databinding.ActivityBuscaBinding
import com.example.idsystem.domain.Pessoas
import retrofit2.Call

class CadastroStatementAdapters(private val dataSet: Call<Pessoas>):RecyclerView.Adapter<CadastroStatementAdapters.ViewHolder>(){

    class ViewHolder(private val binding: ActivityBuscaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pessoas) = with(binding) {
            etPdNome.text=item.nome
            etPdCpf.text=item.cpf
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityBuscaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.bind(item)
    }

    override fun getItemCount() = dataSet.size
}