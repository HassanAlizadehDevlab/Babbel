package com.android.domain.repository

import com.android.domain.entity.WordObject
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