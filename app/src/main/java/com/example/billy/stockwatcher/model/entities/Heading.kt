package com.example.billy.stockwatcher.model.entities

import com.example.billy.stockwatcher.presentation.adapter.AdapterConstants
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType

data class Heading(
        val title: String
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.HEADING
}