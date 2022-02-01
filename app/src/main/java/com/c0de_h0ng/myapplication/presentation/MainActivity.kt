package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.BaseActivity
import com.c0de_h0ng.myapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    private val viewModel by viewModel<MainViewModel>()

    private val sliderHandler = Handler(Looper.getMainLooper())

    private val userProfileListViewPager: UserPagerAdapter by lazy {
        UserPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        viewModel.getUserListResult("mike")
        viewModel.getBookmarkUserList()
    }

    private fun observeViewModel() {
        with(viewModel) {
            userList.observe(this@MainActivity) {
                binding.run {
                    vm = this@with
//                    userListAdapter = UserListAdapter()



                    viewPager2.setAdapter(InfiniteViewPager2Adapter(it))


                }
            }

            bookmarkList.observe(this@MainActivity) {
                Log.d("Bookmark size ", it.size.toString())
            }

            isLoadingObservable.observe(this@MainActivity) {
                when {
                    it -> showLoadingDialog()
                    else -> hideLoadingDialog()
                }
            }
        }
    }



    override fun onPause() {
        super.onPause()
        //sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        //sliderHandler.postDelayed(sliderRunnable, 4000)
    }

//    private val sliderRunnable = Runnable {
//        binding.viewPager.currentItem = binding.viewPager.currentItem + 1
//
//    }

}