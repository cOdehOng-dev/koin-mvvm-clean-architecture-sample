package com.c0de_h0ng.myapplication.presentation.di

import androidx.room.Room
import com.c0de_h0ng.data.datasource.SampleLocalDataSource
import com.c0de_h0ng.data.datasource.SampleLocalDataSourceImpl
import com.c0de_h0ng.data.datasource.SampleRemoteDataSource
import com.c0de_h0ng.data.datasource.SampleRemoteDataSourceImpl
import com.c0de_h0ng.data.local.database.BookmarkDatabase
import com.c0de_h0ng.data.remote.GitHubApi
import com.c0de_h0ng.data.repository.SampleRepositoryImpl
import com.c0de_h0ng.domain.repository.SampleRepository
import com.c0de_h0ng.domain.usecase.GetBookmarkUserListUseCase
import com.c0de_h0ng.domain.usecase.GetUserListUseCase
import com.c0de_h0ng.domain.usecase.InsertBookmarkUseCase
import com.c0de_h0ng.domain.usecase.SearchBookmarkUseCase
import com.c0de_h0ng.myapplication.presentation.MainViewModel
import com.c0de_h0ng.myapplication.presentation.common.Constants
import com.c0de_h0ng.myapplication.presentation.common.PrettyHttpLogging
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
 * Created by c0de_h0ng on 2022/01/31.
 */
object AppModule {

    val retrofitModule = module {
        single {
            OkHttpClient.Builder()
                .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(HttpLoggingInterceptor(PrettyHttpLogging()).apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
        }

        single {
            get<Retrofit>().create(GitHubApi::class.java)
        }
    }

    val datasourceModule = module {
        single<SampleRemoteDataSource> { SampleRemoteDataSourceImpl(get()) }
        single<SampleLocalDataSource> { SampleLocalDataSourceImpl(get()) }
    }

    val localDataModule = module {
        single { get<BookmarkDatabase>().bookmarkUserDao() }
        single {
            Room.databaseBuilder(
                get(),
                BookmarkDatabase::class.java,
                "bookmark_user.db"
            )
                .build()
        }
    }

    val repositoryModule = module {
        single<SampleRepository> { SampleRepositoryImpl(get(), get()) }
    }

    val useCaseModule = module {
        single { GetUserListUseCase(get()) }
        single { GetBookmarkUserListUseCase(get()) }
        single { InsertBookmarkUseCase(get()) }
        single { SearchBookmarkUseCase(get()) }
    }

    val viewModelModule = module {
        viewModel { MainViewModel(get(), get(), get(), get()) }
    }
}