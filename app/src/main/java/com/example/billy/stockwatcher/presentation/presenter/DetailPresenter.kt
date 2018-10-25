package com.example.billy.stockwatcher.presentation.presenter

import android.annotation.SuppressLint
import com.example.billy.stockwatcher.model.UserRepository
import com.example.billy.stockwatcher.presentation.view.DetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailPresenter(private val userRepository: UserRepository) : BasePresenter<DetailView>() {
    @SuppressLint("CheckResult")
    fun getDetails(id: Long) {
        view?.showLoading()
        userRepository.getDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ detailsModel ->
                    view?.hideLoading()
                    view?.showDetails(detailsModel)
                }, { error ->
                    view?.hideLoading()
                    view?.showError(error.message ?:"error")
                })
    }

}