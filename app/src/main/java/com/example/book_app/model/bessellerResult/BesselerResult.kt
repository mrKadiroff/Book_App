package com.example.book_app.bessellerResult

data class BesselerResult(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)