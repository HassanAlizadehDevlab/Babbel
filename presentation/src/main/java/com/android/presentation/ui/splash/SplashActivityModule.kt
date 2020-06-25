package com.android.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import com.android.presentation.common.BaseActivityModule
import com.android.presentation.common.di.PerActivity
import com.android.presentation.common.di.PerFragment
import com.android.presentation.ui.splash.fragment.view.SplashFragment
import com.android.presentation.ui.splash.fragment.view.SplashFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by hassanalizadeh on 24,June,2020
 */
@Module(includes = [BaseActivityModule::class])
abstract class SplashActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [SplashFragmentModule::class])
    abstract fun splashFragmentInjector(): SplashFragment

    @Binds
    @PerActivity
    abstract fun activity(activity: SplashActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun splashNavigator(activity: SplashActivity): SplashNavigator

}