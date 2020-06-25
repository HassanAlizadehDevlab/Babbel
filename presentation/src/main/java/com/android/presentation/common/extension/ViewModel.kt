package com.android.presentation.common.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.android.presentation.common.viewmodel.ViewModelProviderFactory

/**
 * Created by hassanalizadeh on 13,March,2019
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>?, action: (t: T) -> Unit) {
    liveData?.observe(this, Observer { t -> action(t) })
}

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(this, provider)[VM::class.java]