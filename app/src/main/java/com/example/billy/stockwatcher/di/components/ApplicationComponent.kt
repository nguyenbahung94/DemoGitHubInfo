package com.example.billy.stockwatcher.di.components

import com.example.billy.stockwatcher.CustomApplication
import com.example.billy.stockwatcher.di.CustomScope.CustomScope
import com.example.billy.stockwatcher.di.modules.ApplicationModule
import com.example.billy.stockwatcher.di.modules.DetailFragmentModule
import com.example.billy.stockwatcher.di.modules.UserListFragmentModule
import dagger.Component
import javax.inject.Singleton
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: CustomApplication)
    fun plus(userListFragmentModule: UserListFragmentModule): UserListFragmentComponent
    fun plus(detailFragmentModule: DetailFragmentModule): DetailFragmentComponent
}