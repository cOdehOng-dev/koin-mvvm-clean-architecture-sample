package com.c0de_h0ng.myapplication.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.c0de_h0ng.myapplication.R

/**
 * Created by c0de_h0ng on 2022/02/01.
 */
class InfiniteViewPager2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    private var totalItemCount = 0

    private val viewPager2: ViewPager2 by lazy {
        findViewById(R.id.view_pager_infinite)
    }

    private val internalRecyclerView by lazy {
        viewPager2.getChildAt(0) as RecyclerView
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.infinite_view_pager, this, true)
    }

    fun <T : RecyclerView.ViewHolder> setAdapter(adapter: RecyclerView.Adapter<T>) {
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.run {
            addTransformer(MarginPageTransformer(30))
            addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        }

        viewPager2.run {
            this.adapter = adapter
            offscreenPageLimit = 3
            setCurrentItem(1, false)
            setPageTransformer(compositePageTransformer)
            getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        }
        totalItemCount = adapter.itemCount
        internalRecyclerView.apply {
            addOnScrollListener(
                InfiniteScrollBehaviour(
                    totalItemCount,
                    layoutManager as LinearLayoutManager
                )
            )
        }
    }

    fun getCurrentItem(): Int {
        return when (viewPager2.currentItem) {
            0 -> totalItemCount - 3
            totalItemCount - 1 -> 0
            else -> viewPager2.currentItem - 1
        }
    }

    inner class InfiniteScrollBehaviour(
        private val itemCount: Int,
        private val layoutManager: LinearLayoutManager
    ) : RecyclerView.OnScrollListener() {

        override fun onScrolled(
            recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val firstItemVisible
                    = layoutManager.findFirstVisibleItemPosition()
            val lastItemVisible
                    = layoutManager.findLastVisibleItemPosition()
            if (firstItemVisible == (itemCount - 1) && dx > 0) {
                recyclerView.scrollToPosition(1)
            } else if (lastItemVisible == 0 && dx < 0) {
                recyclerView.scrollToPosition(itemCount - 2)
            }
        }
    }

}