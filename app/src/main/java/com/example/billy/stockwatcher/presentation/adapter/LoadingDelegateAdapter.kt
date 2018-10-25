package com.example.billy.stockwatcher.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.example.billy.stockwatcher.presentation.view.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup)
            = LoadingViewHolder(parent.inflate(R.layout.list_item_loading))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}