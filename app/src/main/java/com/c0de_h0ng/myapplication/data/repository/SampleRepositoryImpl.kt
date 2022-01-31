package com.c0de_h0ng.myapplication.data.repository

import com.c0de_h0ng.myapplication.data.datasource.SampleLocalDataSource
import com.c0de_h0ng.myapplication.data.datasource.SampleRemoteDataSource
import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleRepositoryImpl constructor(
    private val remoteDataSource: SampleRemoteDataSource,
    private val localDataSource: SampleLocalDataSource
) : SampleRepository {

    override fun getUserList(searchWord: String): Single<UserDto> {
        return remoteDataSource.getUserList(searchWord).subscribeOn(Schedulers.io())
    }

    override fun insertBookmark(bookmarkUser: BookmarkUserDto): Completable {
        return localDataSource.insertBookmark(bookmarkUser).subscribeOn(Schedulers.io())
    }

    override fun getBookmarkUserList(): Single<List<BookmarkUserDto>> {
        return localDataSource.getBookmarkUserList().subscribeOn(Schedulers.io())
    }

    override fun deleteBookmark(bookmarkUser: BookmarkUserDto): Completable {
        return localDataSource.deleteBookmark(bookmarkUser).subscribeOn(Schedulers.io())
    }

}