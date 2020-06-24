package com.android.data.repository.datasource

import com.android.data.repository.datasource.word.SmartWordDataSource
import com.android.data.repository.datasource.word.WordDataSource
import dagger.Binds
import dagger.Module
import dagger.Reusable

/**
 * Data Sources provider module.
 */
@Module
abstract class DataSourceModule {

    @Binds
    @Reusable
    abstract fun wordDataSource(smart: SmartWordDataSource): WordDataSource

}