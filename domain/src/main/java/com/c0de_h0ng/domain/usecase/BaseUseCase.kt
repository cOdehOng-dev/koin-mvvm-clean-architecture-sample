package com.c0de_h0ng.domain.usecase

import androidx.lifecycle.MutableLiveData

/**
 * Created by c0de_h0ng on 2022/02/02.
 */
abstract class BaseUseCase<R: Any> {
    protected val result = MutableLiveData<CallResult<R>>()
    fun observe() = result
}