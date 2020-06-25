package com.android.presentation.ui.splash.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.android.domain.usecase.invoke
import com.android.domain.usecase.word.GetWordsUseCase
import com.android.presentation.common.view.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val getWordsUseCase: GetWordsUseCase
) : BaseViewModel() {

    val wordsAreReady = MutableLiveData<Boolean>()

    init {
        getWords()
    }

    fun getWords() {
        getWordsUseCase.invoke()
            .onError()
            .subscribe({
                wordsAreReady.value = true
            }, {
                wordsAreReady.value = false
            })
            .track()
    }

}
