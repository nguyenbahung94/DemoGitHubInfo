package com.example.billy.stockwatcher.presentation.presenter

/*
*  * Helper class for MVP pattern
 * Converted from JAVA code
* */
abstract class BasePresenter<T> {
    var view: T? = null
        private set

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    val isViewAttached: Boolean
        get() = view != null
}