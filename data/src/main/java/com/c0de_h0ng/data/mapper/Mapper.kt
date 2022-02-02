package com.c0de_h0ng.data.mapper

import com.c0de_h0ng.data.remote.dto.BookmarkDto
import com.c0de_h0ng.domain.model.BookmarkUser

/**
 * Created by c0de_h0ng on 2022/02/02.
 */

// data -> domain
fun mapperToBookmark(bookmarkDtoList: List<BookmarkDto>): List<BookmarkUser> {
    return bookmarkDtoList.toList().map {
        BookmarkUser(
            id = it.id,
            name = it.name,
            profileUrl = it.profileUrl,
            isBookmark = it.isBookmark
        )
    }
}

// domain -> data
fun BookmarkUser.toBookmarkEntity() = BookmarkDto(
    id,
    name,
    profileUrl,
    isBookmark
)