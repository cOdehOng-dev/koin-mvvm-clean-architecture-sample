package com.c0de_h0ng.myapplication.presentation.common.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<T> constructor(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<T, *>>(diffCallback) {

    override fun onFailedToRecycleView(holder: BaseViewHolder<T, *>): Boolean {
        holder.itemView.animation?.cancel()
        return true
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T, *>) {
        holder.unbind()
    }

}