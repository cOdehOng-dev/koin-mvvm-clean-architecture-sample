package com.c0de_h0ng.myapplication.domain.usecase

import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class GetBookmarkUserListUseCase constructor(
    private val repository: SampleRepository
) : SingleUseCase<String, List<BookmarkUserDto>>() {

    override fun execute(t: String): Single<List<BookmarkUserDto>> {
        return repository.getBookmarkUserList()
    }
}