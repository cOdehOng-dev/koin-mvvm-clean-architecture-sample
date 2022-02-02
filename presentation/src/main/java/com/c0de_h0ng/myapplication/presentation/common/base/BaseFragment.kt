package com.c0de_h0ng.presentation.presentation.common.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
abstract class BaseFragment<VD: ViewDataBinding> : Fragment() {

    lateinit var rootActivity: BaseActivity<*>

    protected lateinit var binding: VD

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>)
            rootActivity = context
    }

//    fun goToFragment(cls: Class<*>, args: Bundle?) {
//        (activity as? BaseActivity<*>)?.goToFragment(cls, args)
//    }

    fun showLoadingDialog() {
        (activity as? BaseActivity<*>)?.showLoadingDialog()
    }

    fun hideLoadingDialog() {
        (activity as? BaseActivity<*>)?.hideLoadingDialog()
    }
}