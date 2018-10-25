package com.example.billy.stockwatcher.presentation.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.billy.stockwatcher.R
import com.example.billy.stockwatcher.model.entities.User
import com.example.billy.stockwatcher.presentation.view.inflate
import com.example.billy.stockwatcher.presentation.view.isLollipopOrAbove
import com.example.billy.stockwatcher.presentation.view.loadUrl
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListAdapter(
        private val users: MutableList<User>,
        private val listener: (User, View) -> Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(users[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent.inflate(R.layout.list_item_user))

    fun addUsers(newUsers: List<User>) {
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    fun clearUsers() {
        users.clear()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("NewApi")
        fun bind(user: User, listener: (User, View) -> Unit) = with(itemView) {
            name.text = user.displayName
            reputation.text = "${user.reputation} points"
            userAvatar.loadUrl(user.profileImage)
            setOnClickListener { listener(user, userAvatar) }

            isLollipopOrAbove { userAvatar.transitionName = "transition${user.userId}" }
        }
    }

}