package com.c0de_h0ng.myapplication.data.remote

import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
interface GitHubApi {

    @GET("users")
    fun getUser(
        @Query("q") searchUser: String
    ) : Single<UserDto>
}