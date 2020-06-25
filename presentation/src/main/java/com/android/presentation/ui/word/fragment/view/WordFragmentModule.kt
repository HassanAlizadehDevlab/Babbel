package com.android.presentation.ui.word.fragment.view

import com.android.presentation.common.di.PerFragment
import com.android.presentation.ui.word.fragment.util.WordProvider
import com.android.presentation.ui.word.fragment.util.WordProvider2020
import com.android.presentation.ui.word.fragment.viewmodel.WordViewModelModule
import dagger.Binds
import dagger.Module

/**
 * Created by hassanalizadeh on 25,June,2020
 */
@Module(includes = [WordViewModelModule::class])
abstract class WordFragmentModule {

    @Binds
    @PerFragment
    abstract fun wordGenerator(generator: WordProvider2020): WordProvider

}