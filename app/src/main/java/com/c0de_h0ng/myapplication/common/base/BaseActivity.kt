package com.c0de_h0ng.myapplication.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
abstract class BaseActivity<VD : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: VD

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }

}