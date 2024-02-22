package com.example.marmitex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnCardapioItemClickListener {

    private lateinit var btnPrevious: Button
    private lateinit var txt_menu: TextView
    private lateinit var txtNomeCardapio: TextView
    private lateinit var txtPratoDia: Button
    private lateinit var imgPratoDia: ImageView
    private lateinit var btnFazerPedido: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPrevious = findViewById(R.id.btn_previous)
        txt_menu = findViewById(R.id.txt_menu)
        txtNomeCardapio = findViewById(R.id.txt_nome_cardapio)
        txtPratoDia = findViewById(R.id.txt_prato_dia)
        imgPratoDia = findViewById(R.id.img_prato_principal)
        btnFazerPedido = findViewById(R.id.btn_fazer_pedido)

        val drawable = resources.getDrawable(R.drawable.foto_feijoada, null)
        imgPratoDia.setImageDrawable(drawable)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val items = listOf(
            CardapioItem("Bife", "Opção 1", "R$20,00", "arroz, feijão, batata frita, salada de folhas"),
            CardapioItem("Frango", "Opção 2", "R$18,00", "arroz, feijão, banana frita, salada de folhas"),
            CardapioItem("Peixe", "Opção 3", "R$22,00", "arroz, feijão, mandioca frita, salada de folhas"),
            CardapioItem("Ovos", "Opção 3", "R$19,00", "arroz, feijão, batata frita, salada de folhas"),
            // Adicione mais itens conforme necessário
        )
        val adapter = CardapioAdapter(items, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: CardapioItem,imageResId: Int) {
        val intent = Intent(this, ProductDetalhes::class.java).apply {
            putExtra("nome", item.nome)
            putExtra("ingredientes", item.ingredientes)
            putExtra("preco", item.preco)
            putExtra("IMAGE_RES_ID", imageResId)
        }
        startActivity(intent)
    }
}