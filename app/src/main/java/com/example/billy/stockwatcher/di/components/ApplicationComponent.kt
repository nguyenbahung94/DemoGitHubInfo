package com.example.billy.stockwatcher.di.components

import com.example.billy.stockwatcher.CustomApplication
import com.example.billy.stockwatcher.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: CustomApplication)
    fun plus(userListFragmentComponent: UserListFragmentComponent): UserListFragmentComponent
    fun plus(detailFragmentComponent: DetailFragmentComponent): DetailFragmentComponent
}