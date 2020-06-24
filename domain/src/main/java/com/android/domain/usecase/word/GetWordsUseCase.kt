package com.android.domain.usecase.word

import com.android.domain.executor.transformer.CTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseCompletable
import io.reactivex.Completable
import javax.inject.Inject

/**
 * An use case to fetch words from remote API.
 */
class GetWordsUseCase @Inject constructor(
    private val wordRepository: WordRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<Unit>() {
    override fun execute(param: Unit): Completable =
        wordRepository.getWords().compose(transformer)
}