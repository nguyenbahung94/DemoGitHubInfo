package com.example.billy.stockwatcher.di.components

import com.example.billy.stockwatcher.di.CustomScope.CustomScope
import com.example.billy.stockwatcher.di.modules.DetailFragmentModule
import com.example.billy.stockwatcher.presentation.presenter.DetailPresenter
import com.example.billy.stockwatcher.presentation.view.fragment.DetailsFragment
import dagger.Subcomponent
import javax.inject.Singleton
@CustomScope
@Subcomponent(modules = arrayOf(DetailFragmentModule::class))
interface DetailFragmentComponent {
    fun inject(fragment: DetailsFragment)
    fun presenter(): DetailPresenter
}