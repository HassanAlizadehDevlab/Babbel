package com.android.domain.usecase.word

import com.android.domain.entity.WordObject
import com.android.domain.executor.transformer.FTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * An use case to fetch words from remote API and load them from DB.
 */
class LoadWordsUseCase @Inject constructor(
    private val wordRepository: WordRepository,
    private val transformer: FTransformer<List<WordObject>>
) : UseCaseFlowable<List<WordObject>, Unit>() {
    override fun execute(param: Unit): Flowable<List<WordObject>> =
        wordRepository.getWords()
            .andThen(wordRepository.loadWords())
            .compose(transformer)
}