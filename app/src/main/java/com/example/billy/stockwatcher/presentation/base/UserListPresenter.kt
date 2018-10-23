package com.example.billy.stockwatcher.presentation.base

import com.example.billy.stockwatcher.model.entities.User

interface UserListPresenter {
    fun showLoading()
    fun hideLoading()
    fun addUSersTolist(users: List<User>)
    fun showError()
}