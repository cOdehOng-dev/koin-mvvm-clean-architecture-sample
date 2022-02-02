package com.c0de_h0ng.domain.usecase

import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.domain.repository.SampleRepository
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class GetUserListUseCase constructor(
    private val repository: SampleRepository
) : UseCase<String, List<User>>() {

    override fun buildUseCaseFlowable(param: String): Flowable<List<User>> {
        return repository.getUserList(param)
    }

}