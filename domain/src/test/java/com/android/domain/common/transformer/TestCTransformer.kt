package com.android.domain.common.transformer

import com.android.domain.executor.transformer.CTransformer
import io.reactivex.Completable
import io.reactivex.CompletableSource

/**
 * Created by hassanalizadeh on 21,June,2020
 */
class TestCTransformer : CTransformer() {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
    }

}