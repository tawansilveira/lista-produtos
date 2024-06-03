package com.example.listaprodutos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProdutoAdapter(private val produtos: List<Produto>): RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    inner class ProdutoViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(produto: Produto){
            val imgProduto: ImageView = itemView.findViewById(R.id.imageView)
            val txtNomeProduto: TextView = itemView.findViewById(R.id.txt_produto)
            val txtPrecoProduto: TextView = itemView.findViewById(R.id.txt_produto_preco)

            txtNomeProduto.text = produto.nome
            txtPrecoProduto.text = produto.preco

            Glide.with(itemView.context).load(produto.url).into(imgProduto)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.lista_produto_item_layout, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(produtos[position])

    }
}