package com.example.billy.stockwatcher.model.entities

import com.example.billy.stockwatcher.presentation.adapter.AdapterConstants
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.google.gson.annotations.SerializedName

data class Answer(
        @SerializedName("answer_id") val answerId: Long,
        @SerializedName("question_id") val questionId: Long,
        @SerializedName("score") val score: Long,
        @SerializedName("is_accepted") val accepted: Boolean
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.ANSWER

}