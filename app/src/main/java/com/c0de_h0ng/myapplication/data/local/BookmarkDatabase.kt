package com.c0de_h0ng.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
@Database(entities = [BookmarkUserDto::class], version = 1)
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkUserDao(): BookmarkUserDao
}