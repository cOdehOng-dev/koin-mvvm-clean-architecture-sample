package com.c0de_h0ng.myapplication.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.BaseViewHolder
import com.c0de_h0ng.myapplication.databinding.UserProfileItemBinding
import com.c0de_h0ng.myapplication.domain.model.User

/**
 * Created by c0de_h0ng on 2022/02/01.
 */
class InfiniteViewPager2Adapter constructor(
    itemListOriginal: List<User>
) : RecyclerView.Adapter<InfiniteViewPager2Adapter.InfiniteViewHolder>() {

    private val itemList: List<User> = listOf(itemListOriginal.last()) + itemListOriginal + listOf(itemListOriginal.first())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteViewHolder {
        return InfiniteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: InfiniteViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class InfiniteViewHolder(parent: ViewGroup) : BaseViewHolder<User, UserProfileItemBinding>(R.layout.user_profile_item, parent) {

        override fun bind(data: User) {
            binding.run {
                this.profileUrl = data.profileUrl
                this.userName = data.login
            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
}