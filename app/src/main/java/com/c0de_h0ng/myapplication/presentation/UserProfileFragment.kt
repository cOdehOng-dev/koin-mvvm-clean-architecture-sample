package com.c0de_h0ng.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.c0de_h0ng.myapplication.R
import com.c0de_h0ng.myapplication.common.base.BaseFragment
import com.c0de_h0ng.myapplication.databinding.FragmentUserProfileBinding
import com.c0de_h0ng.myapplication.domain.model.User

/**
 * Created by c0de_h0ng on 2022/01/31.
 */
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding>() {

    private var user: User? = null

    override val layoutRes: Int
        get() = R.layout.fragment_user_profile


    companion object {
        fun newInstance(user: User): UserProfileFragment {
            val bundle = Bundle()
            bundle.putParcelable("user_profile", user)
            return UserProfileFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            user = bundle.getParcelable("user_profile")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.run {
            profileUrl = user?.profileUrl
            userName = user?.login
        }
        return binding.root
    }


}