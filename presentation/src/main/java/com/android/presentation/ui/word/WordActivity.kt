package com.android.presentation.ui.word

import android.os.Bundle
import com.android.domain.entity.ResultObject
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.ui.word.fragment.view.WordFragment

class WordActivity : BaseActivity(), WordNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            addFragment(R.id.fragmentContainer, WordFragment.newInstance())
    }

    override fun showCongratulation(result: ResultObject) {
        navigator.toCongratulation(this, result)
        finish()
    }

}