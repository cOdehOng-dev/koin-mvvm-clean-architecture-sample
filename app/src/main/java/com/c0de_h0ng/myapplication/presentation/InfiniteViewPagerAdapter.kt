package com.c0de_h0ng.myapplication.presentation

import android.view.ViewGroup
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.adapter.BaseInfiniteViewPager2Adapter
import com.c0de_h0ng.myapplication.common.base.adapter.BaseViewHolder
import com.c0de_h0ng.myapplication.databinding.UserProfileItemBinding
import com.c0de_h0ng.myapplication.domain.model.User

/**
 * Created by c0de_h0ng on 2022/02/01.
 */
class InfiniteViewPagerAdapter constructor(
    itemListOriginal: List<User>
) : BaseInfiniteViewPager2Adapter<User>(itemListOriginal) {

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
}