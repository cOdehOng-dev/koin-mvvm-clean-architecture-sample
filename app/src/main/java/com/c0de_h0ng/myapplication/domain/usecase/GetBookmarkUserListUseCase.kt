package com.c0de_h0ng.myapplication.domain.usecase

import android.util.Log
import com.c0de_h0ng.myapplication.common.Resource
import com.c0de_h0ng.myapplication.common.base.BaseUseCase
import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.domain.repository.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class GetBookmarkUserListUseCase constructor(
    private val repository: SampleRepository
) : BaseUseCase<List<BookmarkUserDto>>() {

    operator fun invoke(): Disposable {
        return repository.getBookmarkUserList()
            .observeOn(AndroidSchedulers.mainThread())
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