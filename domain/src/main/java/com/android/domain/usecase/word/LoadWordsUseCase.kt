package com.android.domain.usecase.word

import com.android.domain.entity.WordObject
import com.android.domain.executor.transformer.STransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

/**
 * The [LoadWordsUseCase] load some words that not passed and return them to ViewModel.
 * @param param is the count of words that we want to show.
 */
class LoadWordsUseCase @Inject constructor(
    private val repository: WordRepository,
    private val transformer: STransformer<List<WordObject>>
) : UseCaseSingle<List<WordObject>, Int>() {
    override fun execute(param: Int): Single<List<WordObject>> =
        repository.loadWordsByRange(param)
            .compose(transformer)
}