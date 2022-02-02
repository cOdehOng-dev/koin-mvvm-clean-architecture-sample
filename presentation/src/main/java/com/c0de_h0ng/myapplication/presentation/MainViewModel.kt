package com.c0de_h0ng.myapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.c0de_h0ng.domain.model.BookmarkUser
import com.c0de_h0ng.domain.model.User
import com.c0de_h0ng.domain.usecase.CallResult
import com.c0de_h0ng.domain.usecase.GetBookmarkUserListUseCase
import com.c0de_h0ng.domain.usecase.GetUserListUseCase
import com.c0de_h0ng.domain.usecase.InsertBookmarkUseCase
import com.c0de_h0ng.myapplication.presentation.common.base.BaseViewModel

/**
 * Created by c0de_h0ng on 2022/01/30.
 */
class MainViewModel constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val getBookmarkUserListUseCase: GetBookmarkUserListUseCase,
    private val insertBookmarkUseCase: InsertBookmarkUseCase
) : BaseViewModel() {

    private val _userList = MediatorLiveData<List<User>>()
    val userList: LiveData<List<User>>
        get() = _userList

    private val _bookmarkList = MediatorLiveData<List<BookmarkUser>>()
    val bookmarkList: LiveData<List<BookmarkUser>>
        get() = _bookmarkList

    private val _insertBookmark = MediatorLiveData<Boolean>().apply {
        value = false
    }
    val insertBookmark: LiveData<Boolean>
        get() = _insertBookmark


    private val userListResultObserve = getUserListUseCase.observe()
    private val bookmarkListResultObserve = getBookmarkUserListUseCase.observe()
    private val insertBookmarkObserve = insertBookmarkUseCase.observe()

    fun getUserListResult(searchWord: String) {
        this(getUserListUseCase(searchWord))
        _userList.addSource(userListResultObserve) {
            when (it) {
                is CallResult.Success -> {
                    val user = it.data
                    _userList.value = user!!
                }
                is CallResult.Error -> {
                    Log.d("Resource >>> ", "Fail")
                }
                is CallResult.Loading -> {
                    loadingProgress(it.isLoading)
                }
            }
        }
    }

    fun getBookmarkUserList() {
        this(getBookmarkUserListUseCase())
        _bookmarkList.addSource(bookmarkListResultObserve) {
            when (it) {
                is CallResult.Success -> {
                    val user = it.data
                    _bookmarkList.value = user!!
                    Log.d("GetBookmarkList", user.count().toString())
                }
                is CallResult.Error -> {
                    Log.d("Resource >>> ", "Fail")
                }
                is CallResult.Loading -> {
                    loadingProgress(it.isLoading)
                }
            }
        }
    }

    fun insertBookmark(bookmarkUser: BookmarkUser) {
        this(insertBookmarkUseCase(bookmarkUser))
        _insertBookmark.addSource(insertBookmarkObserve) {
            when (it) {
                is CallResult.Success -> {
                    _insertBookmark.value = it.data
                }
                is CallResult.Error -> {
                    Log.d("Resource >>> ", "Fail")
                }
                is CallResult.Loading -> {
                    loadingProgress(it.isLoading)
                }
            }
        }
    }

}