package com.android.babbel

import android.app.Application
import com.android.presentation.common.di.PerActivity
import com.android.presentation.ui.splash.SplashActivity
import com.android.presentation.ui.splash.SplashActivityModule
import com.android.presentation.ui.starter.StarterActivity
import com.android.presentation.ui.starter.StarterActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Define all sub-components for dagger here.
 */
@Module(includes = [AndroidSupportInjectionModule::class])
abstract class BabbelModule {

    @Binds
    @Singleton
    abstract fun application(babbel: Babbel): Application

    @PerActivity
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun splashActivityInjector(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [StarterActivityModule::class])
    abstract fun starterActivityInjector(): StarterActivity

}
