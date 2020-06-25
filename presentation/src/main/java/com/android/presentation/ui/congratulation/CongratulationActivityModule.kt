package com.android.presentation.ui.congratulation

import androidx.appcompat.app.AppCompatActivity
import com.android.presentation.common.BaseActivityModule
import com.android.presentation.common.di.PerActivity
import com.android.presentation.common.di.PerFragment
import com.android.presentation.ui.congratulation.fragment.view.CongratulationFragment
import com.android.presentation.ui.congratulation.fragment.view.CongratulationFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class CongratulationActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [CongratulationFragmentModule::class])
    abstract fun congratulationFragmentInjector(): CongratulationFragment

    @Binds
    @PerActivity
    abstract fun activity(activity: CongratulationActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun congratulationNavigator(activity: CongratulationActivity): CongratulationNavigator

}