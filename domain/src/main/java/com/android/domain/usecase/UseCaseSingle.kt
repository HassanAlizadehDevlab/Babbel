package com.android.domain.usecase

import io.reactivex.Single

/**
 * The [UseCaseSingle] class designed to make Single UseCases calls easier.
 */
abstract class UseCaseSingle<R, P> {

    operator fun invoke(param: P?): Single<R> {
        return if (param != null) {
            execute(param)
        } else {
            Single.error(IllegalArgumentException())
        }
    }

    protected abstract fun execute(param: P): Single<R>

}

operator fun <R> UseCaseSingle<R, Unit>.invoke(): Single<R> = this(Unit)