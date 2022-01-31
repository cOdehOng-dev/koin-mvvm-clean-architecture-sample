package com.c0de_h0ng.myapplication.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c0de_h0ng.myapplication.common.base.BaseListAdapter

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
object BindingAdapter {

    @BindingAdapter(value = ["recycler_view_adapter", "list_data", "touch"], requireAll = false)
    @JvmStatic
    fun bindRecyclerViewAdapter(view: RecyclerView, listAdapter: BaseListAdapter<*>?, list: List<Nothing>?, recyclerTouchListener: RecyclerTouchListener?) {
        listAdapter?.let { adapter ->
            view.adapter = adapter
            adapter.addAll(list)
        }
        recyclerTouchListener?.let { view.addOnItemTouchListener(RecyclerItemListener(it)) }
    }

    @BindingAdapter("img_url")
    @JvmStatic
    fun bindImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .circleCrop()
            .into(imageView)
    }
}