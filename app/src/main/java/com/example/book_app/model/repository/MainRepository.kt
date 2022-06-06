package com.example.book_app.repository

interface MainRepository {

    fun loadData():String

    fun loadCategData(cat:String):String

}