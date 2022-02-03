package com.c0de_h0ng.myapplication.presentation.common.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by c0de_h0ng on 2022/02/03.
 * itemListOriginal: List<T>
 */
abstract class BaseViewPagerAdapter<T> constructor(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<T, *>>(diffCallback) {


    override fun onFailedToRecycleView(holder: BaseViewHolder<T, *>): Boolean {
        holder.itemView.animation?.cancel()
        return true
    }


    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T, *>) {
        holder.unbind()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        val itemList: List<T> by lazy { listOf(currentList.last()) + currentList + listOf(currentList.first()) }
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        if (currentList.isNotEmpty()) {
            val itemList: List<T> by lazy { listOf(currentList.last()) + currentList + listOf(currentList.first()) }
            return itemList.count()
        } else {
            return 0
        }
    }

}