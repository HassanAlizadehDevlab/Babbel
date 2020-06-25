package com.android.domain.common.transformer

import com.android.domain.executor.transformer.MTransformer
import io.reactivex.Maybe
import io.reactivex.MaybeSource

/**
 * Created by hassanalizadeh on 21,June,2020
 */
class TestMTransformer<T> : MTransformer<T>() {

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream
    }

}