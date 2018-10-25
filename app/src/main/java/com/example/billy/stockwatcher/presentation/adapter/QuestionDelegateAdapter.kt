package com.example.billy.stockwatcher.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.model.entities.Question
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.example.billy.stockwatcher.presentation.view.inflate
import kotlinx.android.synthetic.main.list_item_question.view.*

class QuestionDelegateAdapter(private val listener: (String) -> Unit) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = QuestionViewHolder(parent.inflate(R.layout.list_item_question))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as QuestionViewHolder
        holder.bind(item as Question, listener)
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(question: Question, listener: (String) -> Unit) = with(itemView) {
            title.text = question.title
            score.text = "${question.score} points"
            viewCount.text = "Viewed: ${question.viewCount}"

            setOnClickListener { listener(question.link) }
        }
    }
}