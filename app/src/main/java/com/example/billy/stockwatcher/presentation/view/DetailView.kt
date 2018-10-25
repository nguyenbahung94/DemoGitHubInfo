package com.example.billy.stockwatcher.presentation.view

import com.example.billy.stockwatcher.model.entities.DetailsModel

interface DetailView {
    fun showDetails(detailsModel: DetailsModel)
    fun showError(message:String)
    fun showLoading()
    fun hideLoading()
}