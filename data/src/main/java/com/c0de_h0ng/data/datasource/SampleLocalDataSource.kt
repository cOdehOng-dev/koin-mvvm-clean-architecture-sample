package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.dto.BookmarkDto
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
interface SampleLocalDataSource {

    fun getBookmarkUserList(): Flowable<List<BookmarkDto>>
    fun searchBookmark(searchUser: String): Flowable<BookmarkDto>
    fun insertBookmark(bookmark: BookmarkDto): Completable
    fun deleteBookmark(bookmark: BookmarkDto): Completable
}