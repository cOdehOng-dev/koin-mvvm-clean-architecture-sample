package com.c0de_h0ng.myapplication.data.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
@Dao
interface BookmarkUserDao {

    @Query("SELECT * FROM tbl_bookmark_user ORDER BY name DESC")
    fun getBookmarkUserList(): Single<List<BookmarkUserDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmarkUser: BookmarkUserDto): Completable

    @Delete
    fun delete(bookmarkUser: BookmarkUserDto): Completable

//    @Query("UPDATE tbl_bookmark_user SET id = :id WHERE id = :id")
//    fun update(id: Long, searchCount: Long): Int

}