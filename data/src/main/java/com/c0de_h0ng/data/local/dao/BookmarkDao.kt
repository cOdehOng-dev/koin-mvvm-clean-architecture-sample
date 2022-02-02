package com.c0de_h0ng.data.local.dao

import androidx.room.*
import com.c0de_h0ng.data.remote.dto.BookmarkDto
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
@Dao
interface BookmarkDao {

    @Query("SELECT * FROM tbl_bookmark_user ORDER BY name DESC")
    fun getBookmarkUserList(): Flowable<List<BookmarkDto>>

    // TODO Flowalbe로 수정하기
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmark: BookmarkDto): Completable

    @Delete
    fun delete(bookmark: BookmarkDto): Completable

//    @Query("UPDATE tbl_bookmark_user SET id = :id WHERE id = :id")
//    fun update(id: Long, searchCount: Long): Int

}