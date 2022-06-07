package com.example.book_app.repository

import com.example.book_app.categoryApi.CategoryResult

interface MainRepository {

    fun loadData():String

    fun loadCategData(cat:String):CategoryResult

}