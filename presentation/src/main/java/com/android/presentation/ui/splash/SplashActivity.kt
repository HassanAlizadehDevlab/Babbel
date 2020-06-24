package com.android.presentation.ui.splash

import android.os.Bundle
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.ui.splash.fragment.view.SplashFragment

/**
 * Created by hassanalizadeh on 23,June,2020
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.fragmentContainer, SplashFragment.newInstance())
    }

}