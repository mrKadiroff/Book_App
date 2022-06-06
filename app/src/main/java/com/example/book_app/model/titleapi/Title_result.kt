package com.example.book_app.titleapi

data class Title_result(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)