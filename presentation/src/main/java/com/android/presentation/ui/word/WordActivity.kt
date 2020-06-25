package com.android.presentation.ui.word

import android.os.Bundle
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.ui.word.fragment.view.WordFragment

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class WordActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            addFragment(R.id.fragmentContainer, WordFragment.newInstance())
    }

}