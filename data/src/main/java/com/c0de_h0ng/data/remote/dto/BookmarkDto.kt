package com.c0de_h0ng.data.remote.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.c0de_h0ng.domain.model.BookmarkUser

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
@Entity(tableName = "tbl_bookmark_user")
data class BookmarkDto(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "profileUrl")
    val profileUrl: String,

    @ColumnInfo(name = "bookmark")
    val isBookmark: Boolean
)

fun BookmarkDto.toBookmark() = BookmarkUser(
    id, name, profileUrl, isBookmark
)