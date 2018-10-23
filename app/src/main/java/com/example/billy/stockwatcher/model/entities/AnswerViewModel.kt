package com.example.billy.stockwatcher.model.entities

import com.example.billy.stockwatcher.presentation.adapter.AdapterConstants
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType

data class AnswerViewModel(
        val answerId: Long,
        val score: Long,
        val accepted: Boolean,
        val questionTitle: String
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.ANSWER
}