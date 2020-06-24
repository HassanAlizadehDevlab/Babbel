package com.android.domain.executor.transformer

import com.android.domain.executor.PostExecutionThread
import com.android.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableSource
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 24,May,2019
 */
class AsyncCTransformer @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : CTransformer() {

    override fun apply(upstream: Completable): CompletableSource =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}