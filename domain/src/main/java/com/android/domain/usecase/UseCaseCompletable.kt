package com.android.domain.usecase

import io.reactivex.Completable

/**
 * The [UseCaseCompletable] class designed to make Completable UseCases calls easier.
 */
abstract class UseCaseCompletable<P> {

    operator fun invoke(param: P?): Completable {
        return if (param != null) {
            execute(param)
        } else {
            Completable.error(IllegalArgumentException())
        }
    }

    protected abstract fun execute(param: P): Completable

}

operator fun UseCaseCompletable<Unit>.invoke(): Completable = this(Unit)