package com.example.billy.stockwatcher.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.model.entities.AnswerViewModel
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.example.billy.stockwatcher.presentation.view.inflate
import kotlinx.android.synthetic.main.list_item_answer.view.*

class AnswerDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = AnswerViewHolder(parent.inflate(R.layout.list_item_answer))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as AnswerViewHolder
        holder.bind(item as AnswerViewModel, listener)
    }

    class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(answer: AnswerViewModel, listener: (String) -> Unit) = with(itemView) {
            score.text = "${answer.score} points"
            questionTitle.text = answer.questionTitle

            setOnClickListener { listener("https://stackoverflow.com/a/${answer.answerId}") }
        }
    }
}