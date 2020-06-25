package com.android.domain.common.transformer

import com.android.domain.executor.transformer.OTransformer
import io.reactivex.Observable
import io.reactivex.ObservableSource

/**
 * Created by hassanalizadeh on 21,June,2020
 */
class TestOTransformer<T> : OTransformer<T>() {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
    }

}