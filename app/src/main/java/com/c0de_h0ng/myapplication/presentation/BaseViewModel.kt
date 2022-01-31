package com.c0de_h0ng.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
abstract class BaseViewModel : ViewModel() {

    private val _isLoadingObservable = MutableLiveData<Boolean>().apply {
        value = false
    }

    val isLoadingObservable: LiveData<Boolean>
        get() = _isLoadingObservable

    private val disposable = CompositeDisposable()

    operator fun invoke(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}