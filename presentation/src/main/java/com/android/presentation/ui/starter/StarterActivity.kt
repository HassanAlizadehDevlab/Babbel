package com.android.presentation.ui.starter

import android.os.Bundle
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.ui.starter.fragment.view.StarterFragment

/**
 * An activity for the starter page
 */
class StarterActivity : BaseActivity(), StarterNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            addFragment(R.id.fragmentContainer, StarterFragment.newInstance())
    }

    override fun showWordPage() {
        navigator.toWords(this)
        finish()
    }

}