package com.android.domain.executor.transformer

import com.android.domain.executor.PostExecutionThread
import com.android.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.reactivestreams.Publisher
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 24,May,2019
 */
class AsyncFTransformer<T> @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : FTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())

}