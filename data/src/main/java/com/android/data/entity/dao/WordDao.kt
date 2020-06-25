package com.android.data.entity.dao

import androidx.room.*
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(words: List<WordEntity>)

    @Query("SELECT * FROM word WHERE passed=0 LIMIT :range")
    fun selectByRange(range: Int = 10): Single<List<WordEntity>>

    @Query("SELECT COUNT(*) FROM word")
    fun count(): Single<Int>

    @Query("SELECT * FROM word WHERE passed=1 LIMIT 1")
    fun firstPassedWord(): Single<WordEntity>

    @Query("DELETE FROM word")
    fun deleteAll()

}