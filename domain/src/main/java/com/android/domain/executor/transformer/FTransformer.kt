package com.android.domain.executor.transformer

import io.reactivex.rxjava3.core.FlowableTransformer

/**
 * A transformer to io thread for Flowable.
 */
abstract class FTransformer<T> : FlowableTransformer<T, T>