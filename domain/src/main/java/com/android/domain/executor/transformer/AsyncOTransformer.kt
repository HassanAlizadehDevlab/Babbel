package com.android.domain.executor.transformer

import com.android.domain.executor.PostExecutionThread
import com.android.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 24,May,2019
 */
class AsyncOTransformer<T> @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : OTransformer<T>() {


    override fun apply(upstream: Observable<T>): ObservableSource<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}