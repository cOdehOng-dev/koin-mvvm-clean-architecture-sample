package com.c0de_h0ng.myapplication.data.datasource

import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
interface SampleLocalDataSource {

    fun insertBookmark(bookmarkUser: BookmarkUserDto): Completable
    fun getBookmarkUserList(): Single<List<BookmarkUserDto>>
    fun deleteBookmark(bookmarkUser: BookmarkUserDto): Completable
}