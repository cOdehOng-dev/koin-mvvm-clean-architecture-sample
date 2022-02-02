package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import com.c0de_h0ng.domain.model.toBookmarkUser
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.databinding.ActivityMainBinding
import com.c0de_h0ng.myapplication.presentation.common.RecyclerTouchListener
import com.c0de_h0ng.myapplication.presentation.common.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(), RecyclerTouchListener {

    override val layoutRes: Int
        get() = R.layout.activity_main

    private val viewModel by viewModel<MainViewModel>()

    override fun bindingProperty() {
        binding.listTouch = this
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
                    userListAdapter = UserListAdapter()
                    viewPager2.setAdapter(InfiniteViewPagerAdapter(it))
                }
            }

            bookmarkList.observe(this@MainActivity) {
                Log.d("Bookmark size ", it.size.toString())
            }

            insertBookmark.observe(this@MainActivity) {
                Log.d("Insert After Result ", it.toString())
            }

            isLoadingObservable.observe(this@MainActivity) {
                when {
                    it -> showLoadingDialog()
                    else -> hideLoadingDialog()
                }
            }
        }
    }

    override fun onClickItem(v: View, position: Int) {
        if (v.id == R.id.api_user_item) {
            val adapter = binding.userListAdapter
            adapter?.let { listAdapter ->
                val user = listAdapter.getList(position)
                viewModel.insertBookmark(user.toBookmarkUser())
            }
        }
    }

}