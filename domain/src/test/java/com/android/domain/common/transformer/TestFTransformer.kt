package com.android.domain.common.transformer

import com.android.domain.executor.transformer.FTransformer
import io.reactivex.Flowable
import org.reactivestreams.Publisher

/**
 * Created by hassanalizadeh on 21,June,2020
 */
class TestFTransformer<T> : FTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
    }

}