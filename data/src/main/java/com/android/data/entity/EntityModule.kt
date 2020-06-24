package com.android.data.entity

import android.app.Application
import androidx.room.Room
import com.android.data.entity.dao.WordDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Entity provider module.
 */
@Module
class EntityModule {

    @Provides
    fun wordDao(db: BabbelDatabase): WordDao = db.wordDao()

    @Provides
    @Singleton
    fun database(application: Application): BabbelDatabase = Room.databaseBuilder(
        application.applicationContext,
        BabbelDatabase::class.java,
        "babbel_db"
    ).build()

}