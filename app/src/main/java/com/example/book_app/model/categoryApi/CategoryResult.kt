package com.example.book_app.categoryApi

data class CategoryResult(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
)