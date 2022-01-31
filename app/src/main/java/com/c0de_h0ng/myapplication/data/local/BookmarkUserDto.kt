package com.c0de_h0ng.myapplication.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
@Entity(tableName = "tbl_bookmark_user")
data class BookmarkUserDto(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "profileUrl")
    val profileUrl: String,

    @ColumnInfo(name = "bookmark")
    var isBookmark: Boolean,
)
