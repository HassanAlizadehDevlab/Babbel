package com.android.data.repository.datasource.word

import com.android.data.entity.model.local.WordEntity
import com.android.data.entity.model.remote.Word
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

/**
 * The [WordDataSource] is a contract for defining what should implement for Word Data Sources.
 */
interface WordDataSource {
    fun getWords(): Single<List<Word>>
    fun insertWords(words: List<WordEntity>): Completable
    fun loadWords(): Flowable<List<WordEntity>>
}