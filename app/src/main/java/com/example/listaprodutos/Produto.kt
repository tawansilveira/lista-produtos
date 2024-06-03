package com.example.listaprodutos

import java.io.Serializable

data class Produto(
    val nome: String,
    val preco: String,
    val url: String
): Serializable