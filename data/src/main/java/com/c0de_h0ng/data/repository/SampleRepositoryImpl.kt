package com.c0de_h0ng.data.repository

import com.c0de_h0ng.data.datasource.SampleLocalDataSource
import com.c0de_h0ng.data.datasource.SampleRemoteDataSource
import com.c0de_h0ng.data.mapper.mapperToBookmark
import com.c0de_h0ng.data.mapper.toBookmarkEntity
import com.c0de_h0ng.data.remote.dto.toUserList
import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.domain.repository.SampleRepository
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class SampleRepositoryImpl constructor(
    private val remote: SampleRemoteDataSource,
    private val local: SampleLocalDataSource
) : SampleRepository {

    override fun getUserList(searchWord: String): Flowable<List<User>> {
        return remote.getUserList(searchWord).flatMap {
            Flowable.just(it.toUserList())
        }
    }

    override fun insertBookmark(bookmarkUser: BookmarkUser): Completable {
        return local.insertBookmark(bookmarkUser.toBookmarkEntity())
    }

    override fun getBookmarkUserList(): Flowable<List<BookmarkUser>> {
        return local.getBookmarkUserList().flatMap {
            Flowable.just(mapperToBookmark(it))
        }
    }

    override fun deleteBookmark(bookmarkUser: BookmarkUser): Completable {
        return local.deleteBookmark(bookmarkUser.toBookmarkEntity())
    }

}