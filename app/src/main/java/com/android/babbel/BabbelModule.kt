package com.android.babbel

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by hassanalizadeh on 24,June,2020
 */
@Module(includes = [AndroidSupportInjectionModule::class])
abstract class BabbelModule {

    @Binds
    @Singleton
    abstract fun application(babbel: Babbel): Application

}
