package com.android.presentation.common.navigation

import android.content.Context
import android.content.Intent
import com.android.domain.entity.ResultObject
import com.android.presentation.common.Constants
import com.android.presentation.ui.congratulation.CongratulationActivity
import com.android.presentation.ui.starter.StarterActivity
import javax.inject.Inject

/**
 * The [Navigator] class is facilitator for start activities.
 * All start activities handle here.
 */
class Navigator @Inject constructor() {

    fun toStarter(context: Context) {
        context.startActivity(Intent(context, StarterActivity::class.java))
    }

    fun toWords(context: Context) {
        // context.startActivity(Intent(context, WordsActivity::class.java))
    }

    fun toCongratulation(context: Context, result: ResultObject) {
        context.startActivity(Intent(context, CongratulationActivity::class.java).apply {
            putExtra(Constants.PARAM, result)
        })
    }
}