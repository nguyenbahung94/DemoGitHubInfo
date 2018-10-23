package com.example.billy.stockwatcher.model.entities

data class DetailsModel(
        val questions: List<Question>,
        val answers: List<AnswerViewModel>,
        val favorites: List<Question>
)