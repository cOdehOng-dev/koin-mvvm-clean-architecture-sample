package com.c0de_h0ng.myapplication.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
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

    @BindingAdapter(value = ["pager_adapter", "pager_change"], requireAll = false)
    @JvmStatic
    fun bindViewPagerAdapter(viewPager2: ViewPager2, adapter: FragmentStateAdapter?, onPageChangeCallback: ViewPager2.OnPageChangeCallback?) {
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.run {
            addTransformer(MarginPageTransformer(40))
            addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        }
        adapter?.let {
            viewPager2.adapter = it
            viewPager2.offscreenPageLimit = it.itemCount
            viewPager2.setPageTransformer(compositePageTransformer)
            viewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        }
        onPageChangeCallback?.let {
            viewPager2.unregisterOnPageChangeCallback(it)
            viewPager2.registerOnPageChangeCallback(it)
        }
    }

}