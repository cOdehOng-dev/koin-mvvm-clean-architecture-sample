package com.c0de_h0ng.myapplication

import android.app.Application
import com.c0de_h0ng.myapplication.di.repositoryModule
import com.c0de_h0ng.myapplication.di.retrofitModule
import com.c0de_h0ng.myapplication.di.useCaseModule
import com.c0de_h0ng.myapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            logger(if (BuildConfig.DEBUG) {
                AndroidLogger()
            } else {
                EmptyLogger()
            })
            androidContext(this@SampleApplication)
            modules(
                retrofitModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}