package com.example.book_app.repository.Imple

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.book_app.bessellerResult.BesselerResult
import com.example.book_app.categoryApi.CategoryResult
import com.example.book_app.model.RetrofitClient
import com.example.book_app.model.viewmodel.Resource
import com.example.book_app.model.viewmodel.Status
import com.example.book_app.model.viewmodel.UserViewModel
import com.example.book_app.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class MainRepositoryImpl(var viewModelStoreOwner: ViewModelStoreOwner,var lifecycleOwner: LifecycleOwner,var context: Context):MainRepository {
    lateinit var userViewModel: UserViewModel
    private val TAG = "MainRepositoryImpl"
    private var word:String= ""
    private var category:CategoryResult?=null

    //bestseller
    override fun loadData(): String {

        userViewModel = ViewModelProvider(viewModelStoreOwner).get(UserViewModel::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            userViewModel.getWord().observe(lifecycleOwner) {
                when (it.status) {
                    Status.LOADING -> {

                    }

                    Status.ERROR -> {

                    }

                    Status.SUCCESS -> {
                        val copyright = it.data!!.copyright
                        word = copyright


                    }
                }}
        }


        return word
    }

    override fun loadCategData(cat: String): CategoryResult {

        RetrofitClient.apiService().getDataByCategory(cat,"beKOJAq1sjYHYp2raykgNMvjzHt4npjr").enqueue(object:
            Callback<CategoryResult> {
            override fun onResponse(
                call: Call<CategoryResult>,
                response: Response<CategoryResult>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    Log.d(TAG, "onResponse: $body")
                    category = body

                }
            }

            override fun onFailure(call: Call<CategoryResult>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }


        })


        return category!!

    }



}