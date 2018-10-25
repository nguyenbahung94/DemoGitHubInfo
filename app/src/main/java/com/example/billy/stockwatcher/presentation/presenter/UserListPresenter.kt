package com.example.billy.stockwatcher.presentation.presenter

import android.annotation.SuppressLint
import com.example.billy.stockwatcher.model.UserRepository
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.view.UserListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListPresenter(private val userRepository: UserRepository) : BasePresenter<UserListView>() {
    val offset = 5
    var page = 1
    var loading = false
    @SuppressLint("CheckResult")
    fun getUsers() {
        loading = true
        userRepository.getUser(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userlistModel ->
                    loading = false
                    view?.addUsersToList(userlistModel.items)
                    view?.hideLoading()
                    page++
                }, { error ->
                    loading = false
                    view?.showError(error.message ?: "error")
                    view?.hideLoading()
                })

    }

    fun resetPage() {
        page = 1
    }

    fun onScrollChanged(lastVisibleItemPosition: Int, totalItemCount: Int) {
        if (!loading) {
            if (lastVisibleItemPosition >= totalItemCount - offset) {
                getUsers()
            }
        }
        if (loading && lastVisibleItemPosition >= totalItemCount) {
            view?.showLoading()
        }
    }
}