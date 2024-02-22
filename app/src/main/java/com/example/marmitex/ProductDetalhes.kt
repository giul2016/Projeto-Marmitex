package com.example.marmitex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ProductDetalhes : AppCompatActivity() {

    private lateinit var txtNomeCardapio: TextView
    private lateinit var txtPrice: TextView
    private lateinit var imgPrato: ImageView
    private lateinit var txtIngredientes: TextView
    private lateinit var btnFazerPedido: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detalhes)


        txtNomeCardapio = findViewById(R.id.txt_nome_cardapio)
        txtPrice = findViewById(R.id.txt_price)
        imgPrato = findViewById(R.id.img_prato)
        btnFazerPedido = findViewById(R.id.btn_confirm)
        txtIngredientes = findViewById(R.id.txt_ingredientes)

        val imageResId = intent.getIntExtra("IMAGE_RES_ID", R.drawable.ic_launcher_background)
        imgPrato.setImageResource(imageResId)

        // Obter os dados passados pelo Intent
        val nome = intent.getStringExtra("nome")
        val ingredientes = intent.getStringExtra("ingredientes")
        val preco = intent.getStringExtra("preco")

        // Atribuir os dados recebidos às Views
        txtNomeCardapio.text = nome
        txtIngredientes.text = ingredientes
        txtPrice.text = preco

        // Aqui, você também pode configurar um listener para o botão, se necessário
        btnFazerPedido.setOnClickListener {
            // Implemente a ação do botão aqui, se houver alguma
        }
    }
}