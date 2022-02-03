package com.c0de_h0ng.myapplication.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.databinding.UserProfileItemBinding
import com.c0de_h0ng.myapplication.presentation.common.base.adapter.BaseViewHolder
import com.c0de_h0ng.myapplication.presentation.common.base.adapter.BaseViewPagerAdapter

/**
 * Created by c0de_h0ng on 2022/02/01.
 */
class InfiniteViewPagerAdapter : BaseViewPagerAdapter<User>(InfiniteViewPagerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder {
        return InfiniteViewHolder(parent)
    }

    inner class InfiniteViewHolder(parent: ViewGroup) : BaseViewHolder<User, UserProfileItemBinding>(R.layout.user_profile_item, parent) {
        override fun bind(data: User) {
            binding.run {
                this.profileUrl = data.profileUrl
                this.userName = data.login
            }
        }
    }

    private class InfiniteViewPagerDiffCallback: DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }
}