package com.android.domain.common.transformer

import com.android.domain.executor.transformer.STransformer
import io.reactivex.Single
import io.reactivex.SingleSource

/**
 * Created by hassanalizadeh on 21,June,2020
 */
class TestSTransformer<T> : STransformer<T>() {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
    }

}