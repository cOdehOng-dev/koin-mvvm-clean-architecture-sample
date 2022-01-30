package com.c0de_h0ng.myapplication.di

import com.c0de_h0ng.myapplication.common.Constants.BASE_URL
import com.c0de_h0ng.myapplication.common.Constants.CONNECT_TIMEOUT
import com.c0de_h0ng.myapplication.common.Constants.READ_TIMEOUT
import com.c0de_h0ng.myapplication.common.Constants.WRITE_TIMEOUT
import com.c0de_h0ng.myapplication.common.PrettyHttpLogging
import com.c0de_h0ng.myapplication.data.remote.GitHubApi
import com.c0de_h0ng.myapplication.data.repository.SampleRepositoryImpl
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import com.c0de_h0ng.myapplication.domain.usercase.GetUseCase
import com.c0de_h0ng.myapplication.presentation.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
object AppModule {

    // Retrofit2 Module
    val retrofitModule = module {
        single {
            val interceptor = HttpLoggingInterceptor(PrettyHttpLogging())
            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            }
            OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()
        }

        single {
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        }

        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
        }

        single {
            get<Retrofit>().create(GitHubApi::class.java)
        }
    }

    // Repository
    val repositoryModule = module {
        single<SampleRepository> { SampleRepositoryImpl(get()) }
    }

    // UseCase
    val useCaseModule = module {
        factory {
            GetUseCase(get())
        }
    }

    // ViewModel
    val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }

}