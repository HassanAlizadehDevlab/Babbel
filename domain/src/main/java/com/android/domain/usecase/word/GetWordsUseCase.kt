package com.android.domain.usecase.word

import com.android.domain.executor.transformer.CTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseCompletable
import io.reactivex.Completable
import javax.inject.Inject

/**
 * An use case to fetch words from remote API.
 * on Remote APi failure, it'll check DB.
 */
class GetWordsUseCase @Inject constructor(
    private val repository: WordRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<Unit>() {
    override fun execute(param: Unit): Completable =
        repository.getWords()
            .onErrorResumeNext { repository.checkWordsAvailability() }
            .compose(transformer)
}