package com.android.domain.repository

import com.android.domain.entity.WordObject
import io.reactivex.Completable
import io.reactivex.Single

/**
 * The [WordRepository] is responsible for declaring methods for Word entity use cases to contact
 * with Word data sources.
 */
interface WordRepository {
    fun getWords(): Completable
    fun loadWordsByRange(range: Int): Single<List<WordObject>>
    fun passedWordsAvailability(): Completable
}