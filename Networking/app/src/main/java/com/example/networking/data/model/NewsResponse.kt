package com.example.networking.data.model

import com.example.networking.data.model.Article as Article1

data class NewsResponse(
    val articles: List<Article1>,
    val status: String,
    val totalResults: Int
)