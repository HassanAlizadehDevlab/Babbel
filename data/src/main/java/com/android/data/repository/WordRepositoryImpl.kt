package com.android.data.repository

import com.android.data.entity.mapper.map
import com.android.data.repository.datasource.word.WordDataSource
import com.android.domain.entity.WordObject
import com.android.domain.repository.WordRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
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
        .flatMap { dataSource.deleteAll().toSingle { it } }
        .flatMapCompletable { dataSource.insertWords(it) }

    override fun loadWordsByRange(range: Int): Single<List<WordObject>> =
        dataSource.loadWordsByRange(range).map { it.map() }

}