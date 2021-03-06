package com.android.presentation.ui.word.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.android.presentation.common.di.PerFragment
import com.android.presentation.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WordViewModelModule {

    @Binds
    @PerFragment
    @IntoMap
    @ViewModelKey(WordViewModel::class)
    abstract fun viewModel(viewModel: WordViewModel): ViewModel

}