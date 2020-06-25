package com.android.domain.usecase.word

import com.android.domain.entity.WordObject
import com.android.domain.executor.transformer.CTransformer
import com.android.domain.repository.WordRepository
import com.android.domain.usecase.UseCaseCompletable
import io.reactivex.Completable
import javax.inject.Inject

/**
 * An use case for update user answers and save in DB.
 */
class UpdateWordsUseCase @Inject constructor(
    private val repository: WordRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<List<WordObject>>() {
    override fun execute(param: List<WordObject>): Completable =
        repository.updateWords(param).compose(transformer)
}