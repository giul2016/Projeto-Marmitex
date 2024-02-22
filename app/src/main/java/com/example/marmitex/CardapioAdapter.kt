package com.example.marmitex

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardapioAdapter(private val items: List<CardapioItem>,
                      private val listener: OnCardapioItemClickListener) :
    RecyclerView.Adapter<CardapioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardapio, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        val pratoComIngredientes = "${item.nome} - ${item.ingredientes}"

        // Crie um SpannableStringBuilder para aplicar diferentes estilos de texto
        val builder = SpannableStringBuilder(pratoComIngredientes)

        // Aplique uma cor diferente aos ingredientes
        val ingredientesStartIndex = pratoComIngredientes.indexOf(item.ingredientes)
        builder.setSpan(ForegroundColorSpan(Color.WHITE), ingredientesStartIndex, ingredientesStartIndex + item.ingredientes.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Defina o texto formatado no TextView
        holder.nomeCardapio.text = builder
        holder.opcao.text = item.opcao
        holder.preco.text = item.preco

        holder.opcao.setOnClickListener {
            val imageResId = getImageResourceIdForItem(item.nome)
            listener.onItemClick(item,imageResId)
        }
        // Define o clique do item
        holder.itemView.setOnClickListener {
            val imageResId = getImageResourceIdForItem(item.nome)
            listener.onItemClick(item,imageResId)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeCardapio: TextView = itemView.findViewById(R.id.txt_nome_cardapio)
        val opcao: TextView = itemView.findViewById(R.id.txt_opcao)
        val preco: TextView = itemView.findViewById(R.id.textPrice)
    }

    fun getImageResourceIdForItem(itemName: String): Int {
        return when (itemName.toLowerCase()) {
            "bife" -> R.drawable.prato_bife
            "frango" -> R.drawable.prato_frango
            "peixe" -> R.drawable.prato_peixe
            "ovos" -> R.drawable.prato_ovos
            else -> R.drawable.prato_bife // Uma imagem padrão caso não encontre correspondência
        }
    }

}
