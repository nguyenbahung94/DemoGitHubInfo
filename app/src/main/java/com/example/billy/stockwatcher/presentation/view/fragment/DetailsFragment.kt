package com.example.billy.stockwatcher.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.billy.stockwatcher.CustomApplication
import com.example.billy.stockwatcher.model.entities.DetailsModel
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.view.DetailView

class DetailsFragment : Fragment(), DetailView {
    private val component by lazy { }
    private val presenter by lazy { }
    private val detailsAdapter by lazy {
    }
    var transitionEnded = false

    companion object {
        fun newInstance(user: User): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable("user", user)
            fragment.arguments = args
            return fragment
        }
    }

    override fun showDetails(detailsModel: DetailsModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}