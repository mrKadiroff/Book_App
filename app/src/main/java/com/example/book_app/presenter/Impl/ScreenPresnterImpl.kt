package com.example.book_app.presenter.Impl

import com.example.book_app.presenter.ScreenPresenter
import com.example.book_app.repository.MainRepository
import com.example.book_app.view.MainView

class ScreenPresnterImpl(var mainView: MainView, var repository: MainRepository):ScreenPresenter {
    override fun getData() {

        val result = repository.loadData()
        mainView.updateData(result)


    }

    override fun getCategoryData(cat: String) {
                val loadCategData = repository.loadCategData(cat)
        mainView.updateCatData(loadCategData)
    }

//    override fun getCategoryData() {
//        val loadCategData = repository.loadCategData()
//        mainView.updateCatData(loadCategData)
//    }


}