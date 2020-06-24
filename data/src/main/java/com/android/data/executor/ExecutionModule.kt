package com.android.data.executor

import com.android.domain.executor.ThreadExecutor
import dagger.Binds
import dagger.Module

/**
 * io Thread provider module.
 */
@Module
abstract class ExecutionModule {

    @Binds
    abstract fun threadExecutor(executor: JobExecutor): ThreadExecutor

}