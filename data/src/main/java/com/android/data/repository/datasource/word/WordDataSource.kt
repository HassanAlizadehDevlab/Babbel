package com.android.data.repository.datasource.word

import com.android.data.entity.model.remote.Word
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * The [WordDataSource] is a contract for defining what should implement for Word Data Sources.
 */
interface WordDataSource {
    fun loadWords(): Completable
    fun words(): Flowable<List<Word>>
}