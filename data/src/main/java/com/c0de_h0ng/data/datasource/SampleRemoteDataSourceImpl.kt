package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.GitHubApi
import com.c0de_h0ng.data.remote.dto.UserDto
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
class SampleRemoteDataSourceImpl constructor(
    private val api: GitHubApi
) : SampleRemoteDataSource {

    override fun getUserList(searchWord: String): Flowable<UserDto> {
        return api.getUser(searchWord)
    }
}