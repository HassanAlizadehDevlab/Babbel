package com.android.presentation.ui.splash.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.android.domain.usecase.invoke
import com.android.domain.usecase.word.GetWordsUseCase
import com.android.presentation.common.view.BaseViewModel
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class SplashViewModel @Inject constructor(
    private val getWordsUseCase: GetWordsUseCase
) : BaseViewModel() {

    val wordsAreReady = MutableLiveData<Boolean>()

    init {
        getWords()
    }

    public fun getWords() {
        getWordsUseCase.invoke()
            .subscribe({
                wordsAreReady.value = true
            }, {
                wordsAreReady.value = false
            })
            .track()
    }

}
