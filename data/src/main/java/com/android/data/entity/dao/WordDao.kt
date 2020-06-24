package com.android.data.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.data.entity.model.local.WordEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * The [WordDao] is a contract for contacting with [WordEntity] table in Database.
 */
@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(words: List<WordEntity>)

    @Query("SELECT * FROM word ORDER BY id")
    fun selectAll(): Flowable<List<WordEntity>>

    @Query("SELECT * FROM word WHERE passed=0 ORDER BY id LIMIT :range")
    fun selectByRange(range: Int = 10): Single<List<WordEntity>>

    @Query("DELETE FROM word")
    fun deleteAll()

}