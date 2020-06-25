package com.android.presentation.ui.congratulation

import android.os.Bundle
import com.android.domain.entity.ResultObject
import com.android.presentation.R
import com.android.presentation.common.BaseActivity
import com.android.presentation.common.Constants
import com.android.presentation.ui.congratulation.fragment.view.CongratulationFragment

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class CongratulationActivity : BaseActivity(), CongratulationNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            addFragment(
                R.id.fragmentContainer, CongratulationFragment.newInstance(
                    intent.getSerializableExtra(Constants.PARAM) as ResultObject
                )
            )
    }

    override fun showWordPage() {
        navigator.toWords(this)
        finish()
    }

}