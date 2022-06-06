package com.example.book_app.bessellerResult

data class Result(
    val age_group: String,
    val author: String,
    val contributor: String,
    val contributor_note: String,
    val description: String,
    val isbns: List<Isbn>,
    val price: String,
    val publisher: String,
    val ranks_history: List<RanksHistory>,
    val reviews: List<Review>,
    val title: String
)