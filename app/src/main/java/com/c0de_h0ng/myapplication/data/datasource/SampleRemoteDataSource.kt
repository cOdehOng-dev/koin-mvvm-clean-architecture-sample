package com.c0de_h0ng.myapplication.data.datasource

import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
interface SampleRemoteDataSource {

    fun getUserList(searchWord: String): Single<UserDto>
}