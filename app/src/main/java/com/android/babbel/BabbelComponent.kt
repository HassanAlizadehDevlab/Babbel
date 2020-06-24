package com.android.babbel

import com.android.data.DataModule
import com.android.domain.DomainModule
import com.android.presentation.PresentationModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by hassanalizadeh on 24,June,2020
 */
@Singleton
@Component(
    modules = [
        BabbelModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface BabbelComponent : AndroidInjector<Babbel> {

    /**
     * Builder for this component
     * */
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<Babbel>()

}