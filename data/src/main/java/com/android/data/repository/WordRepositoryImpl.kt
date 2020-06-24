package com.android.data.repository

import com.android.data.entity.mapper.map
import com.android.data.repository.datasource.word.WordDataSource
import com.android.domain.entity.WordObject
import com.android.domain.repository.WordRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

/**
 * The [WordRepositoryImpl] is the implementation of [WordRepository] interface that is responsible
 * for contacting with Data Sources.
 */
class WordRepositoryImpl @Inject constructor(
    private val dataSource: WordDataSource
) : WordRepository {

    override fun getWords(): Completable = dataSource.getWords()
        .map { it.map() }
        .flatMapCompletable { dataSource.insertWords(it) }

    override fun loadWords(): Flowable<List<WordObject>> = dataSource.loadWords().map { it.map() }

}