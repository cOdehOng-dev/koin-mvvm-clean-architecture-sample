package com.c0de_h0ng.myapplication.presentation.common.base.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
abstract class BaseListAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T, *>>() {

    protected var itemList: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: BaseViewHolder<T, *>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun setList(data: List<T>) {
        clear()
        addAll(data)
    }

    fun getList(index: Int) = itemList[index]

    fun add(data: T) {
        insert(data, itemList.size)
    }

    fun addAll(data: List<T>?) {
        if (data == null) {
            return
        }

        val startIndex = itemList.size
        itemList.addAll(startIndex, data)
        notifyItemRangeInserted(startIndex, data.size)
    }

    fun getItem(position: Int): T {
        return itemList[position]
    }


    fun insert(data: T, position: Int) {
        itemList.add(position, data)
        notifyItemInserted(position)
    }


    fun remove(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }


    fun change(position: Int, data: T) {
        itemList[position] = data
        notifyItemChanged(position)
    }

    fun clear() {
        val size = itemList.size
        itemList.clear()
        notifyItemRangeRemoved(0, size)
    }

}