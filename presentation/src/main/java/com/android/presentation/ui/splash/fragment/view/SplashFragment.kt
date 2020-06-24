package com.android.presentation.ui.splash.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.presentation.R
import com.android.presentation.common.view.BaseFragment

/**
 * Created by hassanalizadeh on 24,June,2020
 */
class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)


    companion object {
        fun newInstance(): SplashFragment = SplashFragment()
    }
}