package com.c0de_h0ng.myapplication.di

import com.c0de_h0ng.myapplication.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}