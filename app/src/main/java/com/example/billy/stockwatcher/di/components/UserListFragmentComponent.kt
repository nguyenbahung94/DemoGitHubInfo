package com.example.billy.stockwatcher.di.components

import com.example.billy.stockwatcher.di.modules.UserListFragmentModule
import com.example.billy.stockwatcher.presentation.base.UserListPresenter
import com.example.billy.stockwatcher.presentation.view.fragment.UserListFragment
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(UserListFragmentModule::class))
interface UserListFragmentComponent {
    fun inject(fragment: UserListFragment)
    fun presenter(): UserListPresenter
}