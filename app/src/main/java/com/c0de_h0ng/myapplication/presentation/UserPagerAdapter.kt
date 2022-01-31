package com.c0de_h0ng.myapplication.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class UserPagerAdapter constructor(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    private val fragmentList: MutableList<Pair<Fragment, Int>> = mutableListOf()

    fun addFragment(fragment: Fragment, fragmentIndex: Int) {
        fragmentList.add(fragment to fragmentIndex)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position].first
    }
}