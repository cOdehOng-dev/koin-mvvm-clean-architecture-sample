package com.c0de_h0ng.myapplication.domain.repository

import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
interface SampleRepository {

    fun getUserList(searchWord: String): Single<UserDto>
    fun insertBookmark(bookmarkUser: BookmarkUserDto): Completable
    fun getBookmarkUserList(): Flowable<List<BookmarkUserDto>>
    fun deleteBookmark(bookmarkUser: BookmarkUserDto): Completable
}