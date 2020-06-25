package com.android.domain

import com.android.domain.entity.WordObject
import com.android.domain.executor.transformer.AsyncCTransformer
import com.android.domain.executor.transformer.AsyncSTransformer
import com.android.domain.executor.transformer.CTransformer
import com.android.domain.executor.transformer.STransformer
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
    abstract fun completableTransformer(
        transformer: AsyncCTransformer
    ): CTransformer

    @Binds
    @Reusable
    abstract fun loadWordsTransformer(
        transformer: AsyncSTransformer<List<WordObject>>
    ): STransformer<List<WordObject>>

}