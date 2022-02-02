package com.c0de_h0ng.myapplication.common

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
