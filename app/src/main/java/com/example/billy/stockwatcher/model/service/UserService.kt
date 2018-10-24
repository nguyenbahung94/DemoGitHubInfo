package com.example.billy.stockwatcher.model.service

import com.example.billy.stockwatcher.model.entities.AnswerListModel
import com.example.billy.stockwatcher.model.entities.QuestionListModel
import com.example.billy.stockwatcher.model.entities.UserListModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("/users?order=desc&sort=reputation&site=stackoverflow")
    fun getUsers(@Query("page") page: Int = 1): Single<UserListModel>

    @GET("/users/{userId}/questions?order=desc&sort=votes&site=stackoverflow")
    fun getQuestionsByUser(@Path("userId") userId: Long): Single<QuestionListModel>

    @GET("/users/{userId}/favorites?order=desc&sort=votes&site=stackoverflow")
    fun getFavoritesByUser(@Path("userId") userId: Long): Single<QuestionListModel>

    @GET("/users/{userId}/answers?order=desc&sort=votes&site=stackoverflow")
    fun getAnswersByUser(@Path("userId") userId: Long): Single<AnswerListModel>
}