package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.BaseActivity
import com.c0de_h0ng.myapplication.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        viewModel.getUserListResult("mike")
    }

    private fun observeViewModel() {
        with(viewModel) {
            userList.observe(this@MainActivity) {
                binding.run {
                    vm = this@with
                    userListAdapter = UserListAdapter()
                }
            }

            isLoadingObservable.observe(this@MainActivity) {
                when {
                    it -> showLoadingDialog()
                    else -> hideLoadingDialog()
                }
            }
        }

    }

}