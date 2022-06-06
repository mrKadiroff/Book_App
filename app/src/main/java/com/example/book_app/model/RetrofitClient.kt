package com.example.book_app.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun apiService() :RetrofitService{
        return getRetrofit().create(RetrofitService::class.java)
    }

}