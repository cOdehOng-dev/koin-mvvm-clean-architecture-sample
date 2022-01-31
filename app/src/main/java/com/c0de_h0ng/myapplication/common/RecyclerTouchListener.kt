package com.c0de_h0ng.myapplication.common

import android.view.View

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
interface RecyclerTouchListener {
    fun onClickItem(v: View, position: Int)
}