package com.c0de_h0ng.myapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
@Parcelize
data class User(
    val id: Int,
    val login: String,
    val profileUrl: String,
    val htmlUrl: String,
    val reposUrl: String
) : Parcelable