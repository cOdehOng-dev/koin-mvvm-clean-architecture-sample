package com.c0de_h0ng.myapplication.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.databinding.UserListItemBinding
import com.c0de_h0ng.myapplication.presentation.common.base.adapter.BaseListAdapter
import com.c0de_h0ng.myapplication.presentation.common.base.adapter.BaseViewHolder

/**
 * Created by c0de_h0ng on 2022/01/31.
 * https://velog.io/@dev_thk28/Android-RecyclerView%EC%99%80-ListAdapter-Java
 * https://youngest-programming.tistory.com/474
 * https://cliearl.github.io/posts/android/recyclerview-listadapter/
 */
class UserListAdapter : BaseListAdapter<User>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent)
    }

    inner class UserViewHolder(parent: ViewGroup) : BaseViewHolder<User, UserListItemBinding>(R.layout.user_list_item, parent) {
        override fun bind(data: User) {
            binding.run {
                this.profileUrl = data.profileUrl
                this.userName = data.login
            }
        }

    }

    private class UserDiffCallback: DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
//            return oldItem.id == newItem.id
//                    && oldItem.htmlUrl == newItem.htmlUrl
//                    && oldItem.profileUrl == newItem.profileUrl
//                    && oldItem.reposUrl == newItem.reposUrl
        }

    }
}