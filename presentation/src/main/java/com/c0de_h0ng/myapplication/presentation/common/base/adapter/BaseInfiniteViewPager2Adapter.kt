package com.c0de_h0ng.myapplication.presentation.common.base.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/02/01.
 */
abstract class BaseInfiniteViewPager2Adapter<T> constructor(
    itemListOriginal: List<T>
) : RecyclerView.Adapter<BaseViewHolder<T, *>>() {

    private val itemList: List<T> = listOf(itemListOriginal.last()) + itemListOriginal + listOf(itemListOriginal.first())

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.count()

}