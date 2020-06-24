package com.android.data.network

import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Remote API provider.
 */
@Module
class NetworkModule {

    @Provides
    @Reusable
    fun wordsDataService(dataServiceFactory: DataServiceFactory): DataServiceWords =
        dataServiceFactory.create(DataServiceWords::class.java)

}