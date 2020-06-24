package com.android.presentation.common.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * eFragment manager extensions for facilitation.
 */
internal fun FragmentManager.addFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean = false) {
    this.beginTransaction()
        .add(containerViewId, fragment)
        .apply { if (addToBackStack) addToBackStack(null) }
        .commit()
}

internal fun FragmentManager.detachFragment(fragment: Fragment, popBackStack: Boolean = false) {
    this.beginTransaction()
        .detach(fragment)
        .commit()
    if (popBackStack) popBackStack()
}