package com.c0de_h0ng.domain.model

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
data class BookmarkUser(
    val id: Long,
    val name: String,
    val profileUrl: String,
    val isBookmark: Boolean
)
