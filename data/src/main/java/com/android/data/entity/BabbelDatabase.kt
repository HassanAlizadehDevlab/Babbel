package com.android.data.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.data.entity.dao.WordDao
import com.android.data.entity.model.local.WordEntity

/**
 * The Babbel's Database.
 */
@Database(
    entities = [WordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class BabbelDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

}