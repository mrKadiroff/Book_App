package com.example.book_app.model.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book_app.bessellerResult.BesselerResult
import com.example.book_app.categoryApi.CategoryResult
import com.example.book_app.model.RetrofitClient
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val liveData = MutableLiveData<Resource<BesselerResult>>()
    private val liveCategoryData = MutableLiveData<Resource<CategoryResult>>()

    fun getWord(): LiveData<Resource<BesselerResult>> {
        val apiService1 = RetrofitClient.apiService()

        viewModelScope.launch {
            liveData.postValue(Resource.loading(null))

            try {
                coroutineScope {

                    val async1 = async { apiService1.getDataByBestseller("beKOJAq1sjYHYp2raykgNMvjzHt4npjr") }

                    val await1 = async1.await()

                    liveData.postValue(Resource.success(await1))

                }
            }catch (e:Exception){
                liveData.postValue(Resource.error(e.message ?: "Error",null))
            }



        }
        return liveData
    }










}