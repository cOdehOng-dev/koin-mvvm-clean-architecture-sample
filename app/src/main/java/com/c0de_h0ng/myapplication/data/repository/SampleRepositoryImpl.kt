package com.c0de_h0ng.myapplication.data.repository

import com.c0de_h0ng.myapplication.data.remote.GitHubApi
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.Single

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class SampleRepositoryImpl constructor(
    private val api: GitHubApi
) : SampleRepository {

    override fun getUserList(searchWord: String): Single<UserDto> = api.getUser(searchWord)

}