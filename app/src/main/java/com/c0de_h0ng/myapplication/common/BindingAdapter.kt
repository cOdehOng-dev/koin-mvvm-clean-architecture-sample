package com.c0de_h0ng.myapplication.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.c0de_h0ng.myapplication.common.base.BaseListAdapter

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
object BindingAdapter {

    @BindingAdapter(value = ["recycler_view_adapter", "touch"])
    @JvmStatic
    fun bindRecyclerViewAdapter(view: RecyclerView, listAdapter: BaseListAdapter<*>?, recyclerTouchListener: RecyclerTouchListener?) {
        listAdapter?.let { view.adapter = it }
        recyclerTouchListener?.let { view.addOnItemTouchListener(RecyclerItemListener(it)) }
    }
}