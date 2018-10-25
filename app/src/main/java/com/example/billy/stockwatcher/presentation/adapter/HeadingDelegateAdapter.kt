package com.example.billy.stockwatcher.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.model.entities.Heading
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.example.billy.stockwatcher.presentation.view.inflate
import kotlinx.android.synthetic.main.list_item_heading.view.*

class HeadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = HeadingViewHolder(parent.inflate(R.layout.list_item_heading))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as HeadingViewHolder
        holder.bind(item as Heading)
    }

    class HeadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(heading: Heading) = with(itemView) {
            title.text = heading.title
        }
    }
}