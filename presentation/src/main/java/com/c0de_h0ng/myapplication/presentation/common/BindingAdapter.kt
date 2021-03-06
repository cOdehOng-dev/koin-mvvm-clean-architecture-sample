package com.c0de_h0ng.myapplication.presentation.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
object BindingAdapter {

//    @BindingAdapter(value = ["recycler_view_adapter", "list_data", "touch"], requireAll = false)
//    @JvmStatic
//    fun bindRecyclerViewAdapter(view: RecyclerView, listAdapter: BaseListAdapter<*>?, list: List<Nothing>?, recyclerTouchListener: RecyclerTouchListener?) {
//        listAdapter?.let { adapter ->
//            view.adapter = adapter
//            adapter.submitList(list?.toMutableList() ?: emptyList())
//            //adapter.addAll(list)
//        }
//        recyclerTouchListener?.let { view.addOnItemTouchListener(RecyclerItemListener(view, it)) }
//    }

    @BindingAdapter("img_url")
    @JvmStatic
    fun bindImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url)
            .circleCrop()
            .into(imageView)
    }

}