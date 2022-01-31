package com.c0de_h0ng.myapplication.domain.usecase

import android.util.Log
import com.c0de_h0ng.myapplication.common.CallResult
import com.c0de_h0ng.myapplication.common.base.BaseUseCase
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class GetUserListUseCase constructor(
    private val repository: SampleRepository
) : BaseUseCase<UserDto>() {

    operator fun invoke(searchWord: String): Disposable {
        return repository.getUserList(searchWord)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                result.value = CallResult.Loading(isLoading = true)
            }
            .doOnTerminate {
                result.value = CallResult.Loading(isLoading = false)
            }
            .subscribe(
                {
                    Log.d("Result >>> ", "Success")
                    result.value = CallResult.Success(it)
                }, {
                    Log.d("Result >>> ", it.localizedMessage ?: "An unexpected error occured")
                    result.value = CallResult.Error(it.localizedMessage ?: "An unexpected error occured")
                }
            )
    }

}