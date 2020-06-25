package com.android.domain.usecase.word

import com.android.domain.executor.transformer.CTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseCompletable
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class PassedWordsAvailabilityUseCase @Inject constructor(
    private val repository: WordRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<Unit>() {
    override fun execute(param: Unit): Completable =
        repository.passedWordsAvailability().compose(transformer)
}