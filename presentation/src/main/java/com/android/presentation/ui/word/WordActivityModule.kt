package com.android.presentation.ui.word

import androidx.appcompat.app.AppCompatActivity
import com.android.presentation.common.BaseActivityModule
import com.android.presentation.common.di.PerActivity
import com.android.presentation.common.di.PerFragment
import com.android.presentation.ui.word.fragment.view.WordFragment
import com.android.presentation.ui.word.fragment.view.WordFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class WordActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [WordFragmentModule::class])
    abstract fun wordFragmentInjector(): WordFragment

    @Binds
    @PerActivity
    abstract fun activity(activity: WordActivity): AppCompatActivity

    @Binds
    @PerActivity
    abstract fun wordNavigator(activity: WordActivity): WordNavigator

}