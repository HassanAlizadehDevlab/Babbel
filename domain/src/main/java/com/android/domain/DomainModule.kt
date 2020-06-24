package com.android.domain

import com.android.domain.executor.transformer.AsyncCTransformer
import com.android.domain.executor.transformer.CTransformer
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

}