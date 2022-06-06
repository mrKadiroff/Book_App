package com.example.book_app.repository.Imple

import android.util.Log
import com.example.book_app.bessellerResult.BesselerResult
import com.example.book_app.model.RetrofitClient
import com.example.book_app.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl:MainRepository {
    private val TAG = "MainRepositoryImpl"
    private var word:String= ""
    override fun loadData(): String {
                RetrofitClient.apiService().getDataByBestseller("beKOJAq1sjYHYp2raykgNMvjzHt4npjr").enqueue(object:
                    Callback<BesselerResult> {
            override fun onResponse(
                call: Call<BesselerResult>,
                response: Response<BesselerResult>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    word = body!!.copyright
                    Log.d(TAG, "onResponse: $body")
                }
            }

            override fun onFailure(call: Call<BesselerResult>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }


        })

        return word
    }

}