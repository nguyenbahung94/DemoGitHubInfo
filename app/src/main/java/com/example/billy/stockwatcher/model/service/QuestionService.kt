package com.example.billy.stockwatcher.model.service

import com.example.billy.stockwatcher.model.entities.QuestionListModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionService {
    @GET("/questions/{questionIds}?order=desc&sort=activity&site=stackoverflow")
    fun getQuestionById(@Path("questionIds") questionId: String): Single<QuestionListModel>
}