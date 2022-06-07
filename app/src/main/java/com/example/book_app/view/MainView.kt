package com.example.book_app.view

import com.example.book_app.categoryApi.CategoryResult

interface MainView {

    fun clickButton()

    fun updateData(word:String)

    fun updateCatData(categ:CategoryResult)

}