package com.android.domain.repository

import com.android.domain.entity.WordObject
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * The [WordRepository] is responsible for declaring methods for Word entity use cases to contact
 * with Word data sources.
 */
interface WordRepository {
    fun getWords(): Completable
    fun loadWords(): Flowable<List<WordObject>>
}