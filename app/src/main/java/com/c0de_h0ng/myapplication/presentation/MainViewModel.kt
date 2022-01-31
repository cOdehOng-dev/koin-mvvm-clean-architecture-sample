package com.c0de_h0ng.myapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.c0de_h0ng.myapplication.common.Resource
import com.c0de_h0ng.myapplication.common.base.BaseViewModel
import com.c0de_h0ng.myapplication.data.local.BookmarkUserDto
import com.c0de_h0ng.myapplication.data.remote.dto.toUserList
import com.c0de_h0ng.myapplication.domain.model.User
import com.c0de_h0ng.myapplication.domain.usecase.GetBookmarkUserListUseCase
import com.c0de_h0ng.myapplication.domain.usecase.GetUseCase

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class MainViewModel constructor(
    private val getUseCase: GetUseCase,
    private val getBookmarkUserListUseCase: GetBookmarkUserListUseCase
) : BaseViewModel() {

    private val _userList = MediatorLiveData<List<User>>()
    val userList: LiveData<List<User>>
        get() = _userList

    private val _bookmarkList = MediatorLiveData<List<BookmarkUserDto>>()
    val bookmarkList: LiveData<List<BookmarkUserDto>>
        get() = _bookmarkList

    private val userListResultObserve = getUseCase.observe()
    private val bookmarkListResultObserve = getBookmarkUserListUseCase.observe()

    fun getUserListResult(searchWord: String) {
        showLoading()
        this(getUseCase(searchWord))
        _userList.addSource(userListResultObserve) {
            hideLoading()
            when (it) {
                is Resource.Success -> {
                    val user = userListResultObserve.value?.data?.toUserList()
                    _userList.value = user
                }
                is Resource.Error -> {
                    Log.d("Resource >>> ", "Fail")
                }
            }
        }
    }

    fun getBookmarkUserList() {
        this(getBookmarkUserListUseCase(""))
        _bookmarkList.addSource(bookmarkListResultObserve) {
            when (it) {
                is Resource.Success -> {
                    val user = bookmarkListResultObserve.value?.data
                    _bookmarkList.value = user
                }
                is Resource.Error -> {
                    Log.d("Resource >>> ", "Fail")
                }
            }
        }
    }

}