package com.android.presentation.common

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.android.presentation.common.extension.addFragment
import com.android.presentation.common.extension.detachFragment
import com.android.presentation.common.extension.toast
import com.android.presentation.common.navigation.Navigator
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Base class for all activities.
 */
open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    protected fun addFragment(
        @IdRes containerViewId: Int, fragment: Fragment,
        addToBackStack: Boolean = false
    ) {
        supportFragmentManager.addFragment(containerViewId, fragment, addToBackStack)
    }

    protected fun detachFragment(fragment: Fragment, popBackStack: Boolean = false) {
        supportFragmentManager.detachFragment(fragment, popBackStack)
    }

    protected fun showMessage(@StringRes resourceId: Int) {
        showMessage(getString(resourceId))
    }

    protected fun showMessage(message: String) {
        toast(message)
    }

}