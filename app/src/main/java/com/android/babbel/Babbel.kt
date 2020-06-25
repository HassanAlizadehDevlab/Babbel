package com.android.babbel

import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Application class.
 */
class Babbel : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerBabbelComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        createDBLogger()
    }

    private fun createDBLogger() {
        if (BuildConfig.DEBUG) {
            val debugDB = Class.forName("com.amitshekhar.DebugDB")
            val getAddressLog = debugDB.getMethod("getAddressLog")
            val value = getAddressLog.invoke(null)
            Log.i("Hassan", "DB debug address: $value")
        }
    }

}