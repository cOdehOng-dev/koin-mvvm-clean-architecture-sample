package com.c0de_h0ng.myapplication.presentation.common.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.myapplication.presentation.UserListAdapter
import com.c0de_h0ng.myapplication.presentation.common.RecyclerItemListener
import com.c0de_h0ng.myapplication.presentation.common.RecyclerTouchListener
import com.c0de_h0ng.myapplication.presentation.common.base.adapter.BaseListAdapter

/**
 * Created by c0de_h0ng on 2022/02/03.
 */

@BindingAdapter("setUserItems")
fun RecyclerView.setUserItems(items: List<User>?) {
    items?.let {
        (adapter as UserListAdapter).submitList(it.toMutableList())
    }
}


@BindingAdapter(value = ["recycler_view_adapter", "list_data", "touch"], requireAll = false)
fun bindRecyclerViewAdapter(view: RecyclerView, listAdapter: BaseListAdapter<*>?, list: List<Nothing>?, recyclerTouchListener: RecyclerTouchListener?) {
    listAdapter?.let { adapter ->
        view.adapter = adapter
        adapter.submitList(list?.toMutableList() ?: emptyList())
        //adapter.addAll(list)
    }
    recyclerTouchListener?.let { view.addOnItemTouchListener(RecyclerItemListener(view, it)) }
}