package com.example.book_app.model

import com.example.book_app.bessellerResult.BesselerResult
import com.example.book_app.categoryApi.CategoryResult
import com.example.book_app.titleapi.Title_result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    // search by title
    @GET("reviews.json")
    fun getDataByTitle(
        @Query("title") title:String,
        @Query("api-key") apikey:String
    ): Call<Title_result>


    // search by author name
    @GET("reviews.json")
    fun getDataByAuthor(
        @Query("author") author:String,
        @Query("api-key") apikey:String
    ): Call<Title_result>


    // search by category name
    @GET("lists/current/{path}.json")
    fun getDataByCategory(
        @Path("path") path: String,
        @Query("api-key") apikey:String
    ): Call<CategoryResult>



    // search besselser books
    @GET("lists/best-sellers/history.json")
    suspend fun getDataByBestseller(
        @Query("api-key") apikey:String
    ): BesselerResult


}