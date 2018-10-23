package com.example.billy.stockwatcher.presentation.view

import com.example.billy.stockwatcher.model.entities.User

interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUsersToList(users: List<User>)
    fun showError()
}