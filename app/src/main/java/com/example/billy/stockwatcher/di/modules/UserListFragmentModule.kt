package com.example.billy.stockwatcher.di.modules

import com.example.billy.stockwatcher.di.CustomScope.CustomScope
import com.example.billy.stockwatcher.model.UserRepository
import com.example.billy.stockwatcher.presentation.presenter.UserListPresenter
import com.example.billy.stockwatcher.presentation.view.fragment.UserListFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserListFragmentModule(val fragment: UserListFragment) {
    @Provides
    @CustomScope
    fun providePresenter(userRepository: UserRepository) = UserListPresenter(userRepository)
}