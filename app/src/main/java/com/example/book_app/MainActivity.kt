package com.example.book_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.example.book_app.bessellerResult.BesselerResult
import com.example.book_app.categoryApi.CategoryResult
import com.example.book_app.databinding.ActivityMainBinding
import com.example.book_app.model.RetrofitClient
import com.example.book_app.model.RetrofitService
import com.example.book_app.presenter.Impl.ScreenPresnterImpl
import com.example.book_app.presenter.ScreenPresenter
import com.example.book_app.repository.Imple.MainRepositoryImpl
import com.example.book_app.repository.MainRepository
import com.example.book_app.titleapi.Title_result
import com.example.book_app.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity(), MainView{
    lateinit var binding: ActivityMainBinding
    var presenter : ScreenPresenter = ScreenPresnterImpl(this,MainRepositoryImpl(this,this,this))
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.addd.setOnClickListener {
          clickButton()

        }




    }

    override fun clickButton() {
        presenter.getCategoryData("Science")
    }

    override fun updateData(word: String) {
            binding.category.text = word



    }

    override fun updateCatData(categ: CategoryResult) {

        Toast.makeText(this, categ.copyright, Toast.LENGTH_SHORT).show()

    }

//    override fun updateCatData(categ: String) {
//        binding.category.text = categ
//    }


}