package com.c0de_h0ng.myapplication.presentation.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.c0de_h0ng.myapplication.presentation.ProgressDialogFragment
import com.c0de_h0ng.myapplication.presentation.common.Constants.PROGRESS_DIALOG_FRAGMENT

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
abstract class BaseActivity<VD : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: VD

    @get:LayoutRes
    protected abstract val layoutRes: Int

    private var dialog: ProgressDialogFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        bindingProperty()
    }

    abstract fun bindingProperty()

    fun showLoadingDialog() {
        if (dialog == null) {
            dialog = ProgressDialogFragment().apply {
                show(supportFragmentManager, PROGRESS_DIALOG_FRAGMENT)
            }
        }
    }

    fun hideLoadingDialog() {
        if (dialog != null) {
            dialog!!.dismiss()
            dialog = null
        }
    }

}