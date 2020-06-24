package com.android.domain.executor.transformer

import com.android.domain.executor.PostExecutionThread
import com.android.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 24,May,2019
 */
class AsyncSTransformer<T> @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : STransformer<T>() {

    override fun apply(upstream: Single<T>): SingleSource<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}