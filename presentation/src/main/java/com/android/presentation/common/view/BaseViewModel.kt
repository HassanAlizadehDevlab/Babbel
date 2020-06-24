package com.android.presentation.common.view

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base class for all ViewModels.
 */
abstract class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    protected fun Disposable.track() {
        disposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}