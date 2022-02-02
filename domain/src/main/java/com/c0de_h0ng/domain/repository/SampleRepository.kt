package com.c0de_h0ng.domain.repository

import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.model.User
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
interface SampleRepository {

    fun getUserList(searchWord: String): Flowable<List<User>>
    fun insertBookmark(bookmarkUser: BookmarkUser): Completable
    fun getBookmarkUserList(): Flowable<List<BookmarkUser>>
    fun deleteBookmark(bookmarkUser: BookmarkUser): Completable
}