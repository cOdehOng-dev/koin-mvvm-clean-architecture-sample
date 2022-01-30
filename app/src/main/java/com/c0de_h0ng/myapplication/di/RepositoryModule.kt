package com.c0de_h0ng.myapplication.di

import com.c0de_h0ng.myapplication.data.repository.SampleRepositoryImpl
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import org.koin.dsl.module

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
val repositoryModule = module {
    single<SampleRepository> { SampleRepositoryImpl(get()) }
}