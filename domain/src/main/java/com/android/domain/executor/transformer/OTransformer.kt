package com.android.domain.executor.transformer

import io.reactivex.rxjava3.core.ObservableTransformer

/**
 * A transformer to io thread for Observable.
 */
abstract class OTransformer<T> : ObservableTransformer<T, T>