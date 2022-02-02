package com.c0de_h0ng.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.c0de_h0ng.data.remote.dto.BookmarkDto
import com.c0de_h0ng.data.local.dao.BookmarkDao

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
@Database(entities = [BookmarkDto::class], version = 1)
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkUserDao(): BookmarkDao
}