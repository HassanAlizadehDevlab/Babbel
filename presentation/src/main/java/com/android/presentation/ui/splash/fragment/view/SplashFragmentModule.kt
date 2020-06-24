package com.android.presentation.ui.splash.fragment.view

import androidx.fragment.app.Fragment
import com.android.presentation.common.di.PerFragment
import dagger.Binds
import dagger.Module

/**
 * Created by hassanalizadeh on 24,June,2020
 */
@Module
abstract class SplashFragmentModule {

    @Binds
    @PerFragment
    abstract fun fragment(fragment: SplashFragment): Fragment

}