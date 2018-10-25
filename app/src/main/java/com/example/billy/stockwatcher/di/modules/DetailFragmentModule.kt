package com.example.billy.stockwatcher.di.modules

import com.example.billy.stockwatcher.di.CustomScope.CustomScope
import com.example.billy.stockwatcher.model.UserRepository
import com.example.billy.stockwatcher.presentation.presenter.DetailPresenter
import com.example.billy.stockwatcher.presentation.view.fragment.DetailsFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DetailFragmentModule(val fragment: DetailsFragment) {
    @Provides
    @CustomScope
    fun providePresenter(userRepository: UserRepository) = DetailPresenter(userRepository)
}