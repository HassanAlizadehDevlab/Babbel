package com.android.data.repository.datasource.word

import com.android.data.entity.model.local.WordEntity
import com.android.data.entity.model.remote.Word
import io.reactivex.Completable
import io.reactivex.Single

/**
 * The [WordDataSource] is a contract for defining what should implement for Word Data Sources.
 */
interface WordDataSource {
    fun getWords(): Single<List<Word>>
    fun checkWordsAvailability(): Completable
    fun insertWords(words: List<WordEntity>): Completable
    fun loadWordsByRange(range: Int): Single<List<WordEntity>>
    fun passedWordsAvailability(): Completable
    fun deleteAll(): Completable
    fun updateWords(words: List<WordEntity>): Completable
}