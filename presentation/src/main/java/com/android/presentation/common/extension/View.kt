package com.android.presentation.common.extension

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.visibleOrGone(status: Boolean) {
    if (status) this.visible() else this.gone()
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}