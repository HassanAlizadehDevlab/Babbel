package com.android.presentation.ui.starter.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.android.domain.usecase.invoke
import com.android.domain.usecase.word.PassedWordsAvailabilityUseCase
import com.android.presentation.common.view.BaseViewModel
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class StarterViewModel @Inject constructor(
    passedWordsAvailabilityUseCase: PassedWordsAvailabilityUseCase
) : BaseViewModel() {

    val passedWordAvailability = MutableLiveData<Boolean>()

    init {
        passedWordsAvailabilityUseCase
            .invoke()
            .subscribe({
                passedWordAvailability.value = true
            }, {
                passedWordAvailability.value = false
            }).track()
    }

}