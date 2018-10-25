package com.example.billy.stockwatcher

import android.app.Application
import com.example.billy.stockwatcher.di.components.ApplicationComponent
import com.example.billy.stockwatcher.di.components.DaggerApplicationComponent
import com.example.billy.stockwatcher.di.modules.ApplicationModule

class CustomApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}