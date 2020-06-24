package com.android.babbel

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by hassanalizadeh on 24,June,2020
 */
class Babbel : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerBabbelComponent.builder().create(this)

}