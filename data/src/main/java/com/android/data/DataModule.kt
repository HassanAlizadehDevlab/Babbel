package com.android.data

import com.android.data.executor.ExecutionModule
import com.android.data.network.NetworkModule
import dagger.Module

/**
 * Data layer object provider module.
 */
@Module(
    includes = [
        ExecutionModule::class,
        NetworkModule::class
    ]
)
abstract class DataModule
