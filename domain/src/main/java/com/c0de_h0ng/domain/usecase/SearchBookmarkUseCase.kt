package com.c0de_h0ng.domain.usecase

import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.repository.SampleRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class SearchBookmarkUseCase constructor(
    private val repository: SampleRepository
) : UseCase<String, BookmarkUser>() {

    override fun buildUseCaseFlowable(param: String): Flowable<BookmarkUser> {
        return repository.searchBookmark(param).subscribeOn(Schedulers.io())
    }
}