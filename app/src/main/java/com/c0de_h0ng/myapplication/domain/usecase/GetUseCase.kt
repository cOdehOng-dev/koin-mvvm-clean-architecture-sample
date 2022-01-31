package com.c0de_h0ng.myapplication.domain.usecase

import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class GetUseCase constructor(
    private val repository: SampleRepository
) : SingleUseCase<String, UserDto>() {

    override fun execute(t: String): Single<UserDto> {
        return repository.getUserList(t)
    }

}