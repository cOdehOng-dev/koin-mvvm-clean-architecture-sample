package com.c0de_h0ng.myapplication.data.repository

import com.c0de_h0ng.myapplication.data.datasource.SampleLocalDataSource
import com.c0de_h0ng.myapplication.data.datasource.SampleRemoteDataSource
import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleRepositoryImpl constructor(
    private val remoteDataSource: SampleRemoteDataSource,
    private val localDataSource: SampleLocalDataSource
) : SampleRepository {

    override fun getUserList(searchWord: String): Single<UserDto> {
        return remoteDataSource.getUserList(searchWord)
    }

    override fun insertBookmark(bookmarkUser: BookmarkUserDto): Completable {
        return localDataSource.insertBookmark(bookmarkUser)
    }

    override fun getBookmarkUserList(): Single<List<BookmarkUserDto>> {
        return localDataSource.getBookmarkUserList()
    }

    override fun deleteBookmark(bookmarkUser: BookmarkUserDto): Completable {
        return localDataSource.deleteBookmark(bookmarkUser)
    }

}