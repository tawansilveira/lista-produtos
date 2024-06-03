package com.example.listaprodutos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

class DetalheFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detalhe, container, false)
        val productBundle = arguments?.getSerializable("produto") as Produto?

        val imgProduto: ImageView = rootView.findViewById(R.id.img_produto_imagem)
        val txtNomeProduto: TextView = rootView.findViewById(R.id.txt_nome_produto)
        val txtPrecoProduto: TextView = rootView.findViewById(R.id.txt_preco_produto)

        txtNomeProduto.text = productBundle?.nome ?: "TESTE"
        txtPrecoProduto.text = productBundle?.preco ?: "teste"

        Glide.with(requireContext()).load(productBundle?.url).into(imgProduto)

        val btBack: ImageButton = rootView.findViewById(R.id.bt_back)

        btBack.setOnClickListener {
            backToHome()
        }

        return rootView

    }

    private fun backToHome() {
        findNavController().navigate(R.id.action_detalheFragment_to_homeFragment)
    }
}
