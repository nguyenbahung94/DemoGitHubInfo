package com.example.billy.stockwatcher.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}