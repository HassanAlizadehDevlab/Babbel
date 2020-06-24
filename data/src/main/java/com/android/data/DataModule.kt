package com.android.data

import com.android.data.executor.ExecutionModule
import com.android.data.network.NetworkModule
import com.android.data.repository.RepositoryModule
import dagger.Module

/**
 * Data layer object provider module.
 */
@Module(
    includes = [
        ExecutionModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
abstract class DataModule
