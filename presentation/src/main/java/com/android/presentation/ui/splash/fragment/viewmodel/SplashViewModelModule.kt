package com.android.presentation.ui.splash.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.android.presentation.common.di.PerFragment
import com.android.presentation.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashViewModelModule {

    @Binds
    @PerFragment
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun viewModel(viewModel: SplashViewModel): ViewModel

}