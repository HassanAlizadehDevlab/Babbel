package com.android.domain.executor.transformer

import io.reactivex.rxjava3.core.SingleTransformer

/**
 * A transformer to io thread for Single.
 */
abstract class STransformer<T> : SingleTransformer<T, T>