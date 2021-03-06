package com.android.presentation.ui.starter

import androidx.appcompat.app.AppCompatActivity
import com.android.presentation.common.BaseActivityModule
import com.android.presentation.common.di.PerActivity
import com.android.presentation.common.di.PerFragment
import com.android.presentation.ui.starter.fragment.view.StarterFragment
import com.android.presentation.ui.starter.fragment.view.StarterFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class StarterActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [StarterFragmentModule::class])
    abstract fun starterFragmentInjector(): StarterFragment

    @Binds
    @PerActivity
    abstract fun activity(activity: StarterActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun starterNavigator(activity: StarterActivity): StarterNavigator

}