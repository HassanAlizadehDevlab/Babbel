package com.android.data

import com.android.data.executor.ExecutionModule
import dagger.Module

/**
 * Data layer object provider module.
 */
@Module(
    includes = [
        ExecutionModule::class
    ]
)
abstract class DataModule
