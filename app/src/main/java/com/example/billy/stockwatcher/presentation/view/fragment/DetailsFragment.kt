package com.example.billy.stockwatcher.presentation.view.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.billy.stockwatcher.CustomApplication
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.di.modules.DetailFragmentModule
import com.example.billy.stockwatcher.model.entities.DetailsModel
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.adapter.DetailsAdapter
import com.example.billy.stockwatcher.presentation.view.DetailView
import com.example.billy.stockwatcher.presentation.view.customApplication
import com.example.billy.stockwatcher.presentation.view.shortToast
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment(), DetailView {
    private val component by lazy { customApplication.component.plus(DetailFragmentModule(this)) }
    private val presenter by lazy { component.presenter() }
    private val detailsAdapter by lazy {
        DetailsAdapter(listener = { link ->
            val browserItent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserItent)
        })
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initAdapter()
        processArguments()
    }

    private fun processArguments() {
        val user = arguments?.getParcelable<User>("user")
        user?.let {
            detailsAdapter.addItem(user)
            detailsAdapter.notifyDataSetChanged()
            presenter.getDetails(user.userId)
        }
    }

    private fun initAdapter() {
        detailsRecyclerView.layoutManager = LinearLayoutManager(customApplication)
        detailsRecyclerView.adapter = detailsAdapter
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()

    }

    override fun showDetails(detailsModel: DetailsModel) {
        with(detailsAdapter) {
            addItemsWithHeading(detailsModel.questions, "Top questions by user")
            addItemsWithHeading(detailsModel.answers, "Top answer by user")
            addItemsWithHeading(detailsModel.favorites, "Favorites by user")
            if (transitionEnded) {
                notifyDataSetChanged()
            }
        }
    }

    override fun showError(message: String) {
        shortToast(message)
    }

    override fun showLoading() {
        detailsAdapter.addLoadingItem()
    }

    override fun hideLoading() {
        detailsAdapter.removeLoadingItem()
    }

    // This logic is needed to show the content only after the shared transition has finished
    fun transitionEnded() {
        transitionEnded = true
        if (isAdded) {
            detailsRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

}