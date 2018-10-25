package com.example.billy.stockwatcher.presentation.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.adapter.viewtype.ViewType
import com.example.billy.stockwatcher.presentation.view.inflate
import com.example.billy.stockwatcher.presentation.view.isLollipopOrAbove
import com.example.billy.stockwatcher.presentation.view.loadUrl
import kotlinx.android.synthetic.main.list_item_user_details.view.*

class UserDetailsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = UserDetailsViewHolder(parent.inflate(R.layout.list_item_user_details))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as UserDetailsViewHolder
        holder.bind(item as User)
    }

    class UserDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("NewApi")
        fun bind(user: User) = with(itemView) {
            profileImage.loadUrl(user.profileImage)
            name.text = user.displayName
            reputation.text = "${user.reputation} points"

            isLollipopOrAbove { profileImage.transitionName = "transition${user.userId}" }
        }
    }
}