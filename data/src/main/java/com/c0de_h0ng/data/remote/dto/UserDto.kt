package com.c0de_h0ng.data.remote.dto

import com.c0de_h0ng.domain.model.User
import com.google.gson.annotations.SerializedName

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
data class UserDto(
    @SerializedName("incomplete_results")
    val isIncompleteResults: Boolean,
    @SerializedName("items")
    val userList: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)

fun UserDto.toUserList(): List<User> {
    return userList.toList().map {
        User(
            id = it.id,
            login = it.login,
            profileUrl = it.avatarUrl,
            htmlUrl = it.htmlUrl,
            reposUrl = it.reposUrl
        )
    }
}