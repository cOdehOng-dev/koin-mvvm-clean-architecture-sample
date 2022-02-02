package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.dto.UserDto
import io.reactivex.Flowable

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
interface SampleRemoteDataSource {

    fun getUserList(searchWord: String): Flowable<UserDto>
}