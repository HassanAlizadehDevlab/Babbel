package com.android.presentation.common.view

import android.content.Context
import androidx.annotation.StringRes
import com.android.presentation.common.extension.toast
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Base class for all fragments.
 */
abstract class BaseFragment : DaggerFragment() {

    @Inject
    protected lateinit var activityContext: Context


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun showMessage(message: MessageData) {
        if (message.message != null) {
            showMessage(message.message!!)
        } else if (message.resource != null) {
            showMessage(message.resource!!)
        }
    }

    fun showMessage(@StringRes resourceId: Int) {
        showMessage(getString(resourceId))
    }

    fun showMessage(message: String) {
        activityContext.toast(message)
    }

}