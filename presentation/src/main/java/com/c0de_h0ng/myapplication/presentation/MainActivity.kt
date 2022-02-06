package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.databinding.ActivityMainBinding
import com.c0de_h0ng.myapplication.presentation.common.RecyclerTouchListener
import com.c0de_h0ng.myapplication.presentation.common.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(), RecyclerTouchListener, View.OnClickListener {

    override val layoutRes: Int
        get() = R.layout.activity_main

    private val viewModel by viewModel<MainViewModel>()

    override fun bindingProperty() {
        binding.listTouch = this
        binding.onClick = this
    }

    private val userAdapter = UserListAdapter()

    private val infiniteViewPagerAdapter = InfiniteViewPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        setAdapter()
        viewModel.getUserListResult("mike")
        viewModel.getBookmarkUserList()
    }

    private fun setAdapter() {
        binding.userRecyclerView.adapter = userAdapter
        //binding.viewPager2.setAdapter(infiniteViewPagerAdapter)
    }

    private fun observeViewModel() {
        with(viewModel) {
            //binding.vm = this
            userList.observe(this@MainActivity) {
                binding.run {
                    //vm = this@with
                    userAdapter.submitList(it)



                    infiniteViewPagerAdapter.submitList(it)
                    binding.viewPager2.setAdapter(infiniteViewPagerAdapter)
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
            searchUser.observe(this@MainActivity) {
                hideLoadingDialog()
                Log.d("Search After Result ", it.toString())
            }
        }
    }

    override fun onClickItem(v: View, position: Int) {
        if (v.id == R.id.api_user_item) {
            val adapter = binding.userListAdapter
            adapter?.let { listAdapter ->
                val user = listAdapter.currentList[position]
                Log.d("ListClick", user.login)



//                val bookmarkName = user.toBookmarkUser().name
//                viewModel.searchBookmark(bookmarkName)
                //viewModel.insertBookmark(user.toBookmarkUser())
            }
        }

    }

    override fun onClick(v: View?) {

    }

}