package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.c0de_h0ng.myapplication.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
        viewModel.getUserListResult("mike")
    }

    private fun observeViewModel() {
        viewModel.userList.observe(this) {
            for (i in it.indices) {
                Log.d("User Result >>> ", it[i].login)
            }
        }
    }
}