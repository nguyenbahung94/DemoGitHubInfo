package com.example.billy.stockwatcher.presentation.base

import com.example.billy.stockwatcher.model.entities.DetailsModel

interface DetailPresenter {
    fun showDetails(detailsModel: DetailsModel)
    fun showError()
    fun showLoading()
    fun hideLoading()
}