package com.android.domain.executor.repository

import com.android.domain.executor.entity.WordObject
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * The [WordRepository] is responsible for declaring methods for Word entity use cases to contact
 * with Word data sources.
 */
interface WordRepository {
    fun getWords(): Completable
    fun loadWords(): Flowable<List<WordObject>>
}