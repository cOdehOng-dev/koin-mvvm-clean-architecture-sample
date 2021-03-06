package com.c0de_h0ng.domain.usecase

import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.repository.SampleRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class GetBookmarkUserListUseCase constructor(
    private val repository: SampleRepository
) : UseCase<Unit, List<BookmarkUser>>() {

    override fun buildUseCaseFlowable(param: Unit): Flowable<List<BookmarkUser>> {
        return repository.getBookmarkUserList().subscribeOn(Schedulers.io())
    }
}