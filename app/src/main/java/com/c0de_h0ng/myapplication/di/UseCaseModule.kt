package com.c0de_h0ng.myapplication.di

import com.c0de_h0ng.myapplication.domain.usercase.GetUseCase
import org.koin.dsl.module

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
val useCaseModule = module {
    factory {
        GetUseCase(get())
    }
}