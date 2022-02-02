package com.c0de_h0ng.presentation.presentation.common

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class RecyclerItemListener constructor(
    private val touchListener: RecyclerTouchListener
) : RecyclerView.OnItemTouchListener {

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        child?.let {
            val position = rv.getChildAdapterPosition(it)
            touchListener.onClickItem(it, position)
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

}