package com.c0de_h0ng.myapplication.presentation.common.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter2<T> constructor(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<T, *>>(diffCallback) {

    protected var itemList: MutableList<T> = mutableListOf()

    override fun onFailedToRecycleView(holder: BaseViewHolder<T, *>): Boolean {
        holder.itemView.animation?.cancel()
        return true
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<T, *>) {
        holder.unbind()
    }

    override fun getItemCount(): Int = itemList.size

    fun getList(index: Int) = itemList[index]

}