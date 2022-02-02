package com.c0de_h0ng.myapplication.presentation.common

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class RecyclerItemListener constructor(
    private val recyclerView: RecyclerView,
    private val touchListener: RecyclerTouchListener
) : GestureDetector.SimpleOnGestureListener(), RecyclerView.OnItemTouchListener {

    private val gestureDetector = GestureDetector(recyclerView.context, this)

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        e?.let { motionEvent ->
            val view: View? = recyclerView.findChildViewUnder(motionEvent.x, motionEvent.y)
            view?.let { touchListener.onClickItem(it, recyclerView.getChildAdapterPosition(it)) }
        }
        return true
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child: View? = recyclerView.findChildViewUnder(e.x, e.y)
        return child != null && gestureDetector.onTouchEvent(e)
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

}