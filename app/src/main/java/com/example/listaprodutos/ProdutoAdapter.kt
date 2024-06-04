package com.example.listaprodutos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProdutoAdapter(
    private val goToDetail: (product: Produto) -> Unit
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(), Filterable {

    private var produtos: List<Produto> = emptyList()
    private var produtosFiltrados: List<Produto> = emptyList()

    fun setProdutos(list: List<Produto>){
        produtos = list
        produtosFiltrados = produtos
        notifyDataSetChanged()
    }

    inner class ProdutoViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(produto: Produto) {
            val imgProduto: ImageView = itemView.findViewById(R.id.imageView)
            val txtNomeProduto: TextView = itemView.findViewById(R.id.txt_produto)
            val txtPrecoProduto: TextView = itemView.findViewById(R.id.txt_produto_preco)

            txtNomeProduto.text = produto.nome
            txtPrecoProduto.text = produto.preco

            Glide.with(itemView.context).load(produto.url).into(imgProduto)

            itemView.setOnClickListener {
                goToDetail(produto)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_produto_item_layout, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = produtosFiltrados.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(produtosFiltrados[position])

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                produtosFiltrados = if (constraint.isNullOrEmpty()){
                    produtos
                } else {
                   val teste = produtos.filter {it.nome.contains(constraint)}
                    teste
                }

                return FilterResults().apply { values = produtosFiltrados as ArrayList<Produto> }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                produtosFiltrados = if (results?.values == null){
                    ArrayList()
                }else{
                    results.values as ArrayList<Produto>
                }

                notifyDataSetChanged()
            }

        }
    }
}