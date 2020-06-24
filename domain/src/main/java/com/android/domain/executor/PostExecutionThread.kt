package com.android.domain.executor

import io.reactivex.rxjava3.core.Scheduler

/**
 * Created by hassanalizadeh on 26,December,2019
 */
interface PostExecutionThread {
    fun scheduler(): Scheduler
}