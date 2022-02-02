package com.c0de_h0ng.myapplication.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.c0de_h0ng.myapplication.R

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class ProgressDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val inflate = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null, false)
        dialog.run {
            setContentView(inflate)
            setCancelable(false)
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        return dialog
    }
}