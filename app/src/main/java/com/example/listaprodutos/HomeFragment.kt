package com.example.listaprodutos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val adapter = ProdutoAdapter(::goToDetail)

        val lista = listOf(
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Passat",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
            Produto(
                "Santana",
                "R$ 18.000,00",
                "https://s2-autoesporte.glbimg.com/Ei2bOmBNdcC3TSJpyVyY99KPmLg=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/t/h/XJQgAVQ5CeGVpTATlF5w/2019-10-03-passatfrente.jpg"
            ),
        )

        adapter.setProdutos(lista)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_lista_produtos)

        recyclerView.adapter = adapter

        view.findViewById<SearchView>(R.id.search_bar)
            .setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    adapter.filter.filter(query)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }

            })

        return view
    }

    private fun goToDetail(product: Produto) {
        val bundle = Bundle()
        bundle.putSerializable("produto", product)
        findNavController().navigate(R.id.action_homeFragment_to_detalhaFragment, bundle)
    }
}
