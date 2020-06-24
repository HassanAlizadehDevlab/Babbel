package com.android.presentation

import com.android.presentation.common.executor.ExecutionModule
import dagger.Module

/**
 * Presentation layer objects provider module.
 */
@Module(includes = [ExecutionModule::class])
abstract class PresentationModule