package com.example.billy.stockwatcher.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.di.modules.UserListFragmentModule
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.adapter.UserListAdapter
import com.example.billy.stockwatcher.presentation.presenter.UserListPresenter
import com.example.billy.stockwatcher.presentation.view.UserListView
import com.example.billy.stockwatcher.presentation.view.activity.MainActivity
import com.example.billy.stockwatcher.presentation.view.customApplication
import com.example.billy.stockwatcher.presentation.view.shortToast
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : Fragment(), UserListView {
    private val component by lazy { customApplication.component.plus(UserListFragmentModule(this)) }
    private val presenter: UserListPresenter by lazy { component.presenter() }
    private val adapter by lazy {
        val userList = mutableListOf<User>()
        UserListAdapter(userList) { user, view ->
            openDetailFragment(user, view)
        }
    }
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initAdapter()

        presenter.attachView(this)

        //prevent reloading when going back
        if (adapter.itemCount == 0) {
            showLoading()
            presenter.getUsers()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(customApplication)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val lastVisibleItemPosition = layoutManager.findFirstVisibleItemPosition() + layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                presenter.onScrollChanged(lastVisibleItemPosition, totalItemCount)
            }
        })
    }

    private fun openDetailFragment(user: User, transitationView: View) {
        val detailsFragment = DetailsFragment.newInstance(user)
        (activity as MainActivity).addDetailsFragmentWithTransition(detailsFragment, transitationView)
    }

    private fun initView() {
        swipeRefreshLayout.setOnRefreshListener {
            adapter.clearUsers()
            presenter.resetPage()
            presenter.getUsers()
        }

    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun addUsersToList(users: List<User>) {
        val adapter = recyclerView.adapter as UserListAdapter
        adapter.addUsers(users)
    }

    override fun showError(message: String) {
        shortToast("Couldn't load data")
    }

}