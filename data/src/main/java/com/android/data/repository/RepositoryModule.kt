package com.android.data.repository

import com.android.data.repository.datasource.DataSourceModule
import com.android.domain.executor.repository.WordRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

/**
 * Repositories provider module.
 */
@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {

    @Binds
    @Reusable
    abstract fun wordRepository(repository: WordRepositoryImpl): WordRepository

}