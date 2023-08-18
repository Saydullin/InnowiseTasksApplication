package com.example.tasksapplication.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tasksapplication.R
import com.example.tasksapplication.databinding.UserCardItemBinding
import com.example.tasksapplication.databinding.UserItemBinding
import com.example.tasksapplication.list.model.User
import com.example.tasksapplication.list.model.UserSex

class UserCardListAdapter(
    val context: Context,
    val data: List<User>
): RecyclerView.Adapter<UserCardListAdapter.ViewHolder>() {

    class ViewHolder(
        userCardItemBinding: UserCardItemBinding
    ): RecyclerView.ViewHolder(userCardItemBinding.root) {
        private val binding = userCardItemBinding

        fun bind(context: Context, user: User) {
            Glide.with(context)
                .load(user.squareAvatarUrl)
                .placeholder(R.color.blue)
                .override(140, 140)
                .into(binding.userImage)
            binding.userFullName.text = "${user.firstName} ${user.lastName}"
            binding.secondaryUserText.text = "Age: ${user.age}"
            binding.thirdUserText.text = user.description
            binding.userSex.text = when(user.sex) {
                UserSex.MALE -> {
                    context.getString(R.string.male)
                }
                UserSex.FEMALE -> {
                    context.getString(R.string.female)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = UserCardItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = data[position]

        holder.bind(context, user)
    }

}