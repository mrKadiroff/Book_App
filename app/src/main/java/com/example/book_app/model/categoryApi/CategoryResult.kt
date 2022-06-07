package com.example.book_app.categoryApi

import com.google.gson.annotations.SerializedName


data class CategoryResult(
    @SerializedName("copyright")
    var copyright: String,
    val last_modified: String,
    val num_results: Int,
    @SerializedName("results")
    val results: Results,
    val status: String
)