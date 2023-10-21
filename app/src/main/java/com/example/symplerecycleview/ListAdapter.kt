package com.example.symplerecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.symplerecycleview.databinding.LayoutitemBinding

class ListAdapter(
    val listItem: MutableList<ListItem>,
    val listener:listListener
):RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder{
     return ViewHolder( LayoutitemBinding.inflate(
         LayoutInflater.from(parent.context),
         parent,
         false
     )
     )
    }


    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.posicao.text = position.toString()
        holder.conteudo.text = item.name

        holder.root.setOnClickListener {
            listener.onItemClicked(item.name)
        }
    }


    class ViewHolder(binding: LayoutitemBinding):RecyclerView.ViewHolder(binding.root){
        var root = binding.root
        var posicao = binding.posicao
        var conteudo = binding.conteudo

    }

    interface listListener {
        fun onItemClicked(content: String)
    }

}