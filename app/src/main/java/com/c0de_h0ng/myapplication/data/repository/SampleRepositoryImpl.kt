package com.c0de_h0ng.myapplication.data.repository

import com.c0de_h0ng.myapplication.data.datasource.SampleRemoteDataSource
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleRepositoryImpl constructor(
    private val dataSource: SampleRemoteDataSource
) : SampleRepository {

    override fun getUserList(searchWord: String): Single<UserDto> {
        return dataSource.getUserList(searchWord)
    }

}