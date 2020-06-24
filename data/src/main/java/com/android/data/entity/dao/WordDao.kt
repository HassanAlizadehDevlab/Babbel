package com.android.data.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.data.entity.model.local.WordEntity
import io.reactivex.rxjava3.core.Flowable

/**
 * The [WordDao] is a contract for contacting with [WordEntity] table in Database.
 */
@Dao
interface WordDao {

    @Insert
    fun insert(words: List<WordEntity>)

    @Query("SELECT * FROM word ORDER BY id")
    fun selectAll(): Flowable<List<WordEntity>>

}