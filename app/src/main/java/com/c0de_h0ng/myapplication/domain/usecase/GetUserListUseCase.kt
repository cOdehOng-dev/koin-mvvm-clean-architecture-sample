package com.c0de_h0ng.myapplication.domain.usecase

import android.util.Log
import com.c0de_h0ng.myapplication.common.Resource
import com.c0de_h0ng.myapplication.common.base.BaseUseCase
import com.c0de_h0ng.myapplication.data.remote.dto.UserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class GetUserListUseCase constructor(
    private val repository: SampleRepository
) : BaseUseCase<UserDto>() {

    operator fun invoke(searchWord: String): Disposable {
        return repository.getUserList(searchWord)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                Log.d("Loading ", "start")
            }
            .doOnTerminate {
                Log.d("Loading ", "finish")
            }
            .subscribe(
                {
                    Log.d("Result >>> ", "Success")
                    result.value = Resource.Success(it)
                }, {
                    Log.d("Result >>> ", it.localizedMessage ?: "An unexpected error occured")
                    result.value = Resource.Error(it.localizedMessage ?: "An unexpected error occured")
                }
            )
    }

}