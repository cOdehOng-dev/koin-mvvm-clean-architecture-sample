package com.c0de_h0ng.myapplication

import android.app.Application
import com.c0de_h0ng.myapplication.di.AppModule.repositoryModule
import com.c0de_h0ng.myapplication.di.AppModule.retrofitModule
import com.c0de_h0ng.myapplication.di.AppModule.useCaseModule
import com.c0de_h0ng.myapplication.di.AppModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
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