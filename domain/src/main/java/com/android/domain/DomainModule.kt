package com.android.domain

import com.android.domain.entity.WordObject
import com.android.domain.executor.transformer.AsyncFTransformer
import com.android.domain.executor.transformer.FTransformer
import dagger.Binds
import dagger.Module
import dagger.Reusable

/**
 * Domain layer object provider module.
 */
@Module
abstract class DomainModule {

    @Binds
    @Reusable
    abstract fun wordTransformer(
        transformer: AsyncFTransformer<List<WordObject>>
    ): FTransformer<List<WordObject>>

}