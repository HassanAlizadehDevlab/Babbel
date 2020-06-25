package com.android.presentation.ui.splash

import android.os.Bundle
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.ui.splash.fragment.view.SplashFragment

class SplashActivity : BaseActivity(), SplashNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            addFragment(R.id.fragmentContainer, SplashFragment.newInstance())
    }

    override fun showStarterPage() {
        navigator.toStarter(this)
        finish()
    }

}