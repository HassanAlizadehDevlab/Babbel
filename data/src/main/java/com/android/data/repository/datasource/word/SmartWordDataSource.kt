package com.android.data.repository.datasource.word

import com.android.data.entity.model.remote.Word
import com.android.data.network.DataServiceWords
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

/**
 * The [SmartWordDataSource] is responsible to implement and work with Data Sources.
 */
class SmartWordDataSource @Inject constructor(
    private val service: DataServiceWords
) : WordDataSource {

    override fun loadWords(): Completable = service.words()
        // .Insert in DB
        .ignoreElement()

    override fun words(): Flowable<List<Word>> {
        TODO("Load words from DB")
    }

}