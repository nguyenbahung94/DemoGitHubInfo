package com.example.billy.stockwatcher.di.modules

import com.example.billy.stockwatcher.CustomApplication
import com.example.billy.stockwatcher.model.UserRepository
import com.example.billy.stockwatcher.model.service.QuestionService
import com.example.billy.stockwatcher.model.service.UserService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(val application: CustomApplication) {
    private val BASE_URL = "https://api.stackexchange.com/2.2/";

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    @Provides
    @Singleton
    fun provideUserRepository(retrofit: Retrofit) =
            UserRepository(
                    retrofit.create(UserService::class.java),
                    retrofit.create(QuestionService::class.java))
}