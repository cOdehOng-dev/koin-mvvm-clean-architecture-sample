package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.dto.BookmarkDto
import com.c0de_h0ng.data.local.dao.BookmarkDao
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class SampleLocalDataSourceImpl constructor(
    private val bookmarkDao: BookmarkDao
) : SampleLocalDataSource {

    override fun insertBookmark(bookmark: BookmarkDto): Completable = bookmarkDao.insert(bookmark)
    override fun getBookmarkUserList(): Flowable<List<BookmarkDto>> = bookmarkDao.getBookmarkUserList()
    override fun deleteBookmark(bookmark: BookmarkDto): Completable = bookmarkDao.delete(bookmark)
}