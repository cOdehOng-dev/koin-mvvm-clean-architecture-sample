package com.c0de_h0ng.myapplication.data.datasource

import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.data.local.BookmarkUserDao
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class SampleLocalDataSourceImpl constructor(
    private val bookmarkUserDao: BookmarkUserDao
) : SampleLocalDataSource {

    override fun insertBookmark(bookmarkUser: BookmarkUserDto): Completable = bookmarkUserDao.insert(bookmarkUser)

    override fun getBookmarkUserList(): Single<List<BookmarkUserDto>> = bookmarkUserDao.getBookmarkUserList()

    override fun deleteBookmark(bookmarkUser: BookmarkUserDto): Completable = bookmarkUserDao.delete(bookmarkUser)
}