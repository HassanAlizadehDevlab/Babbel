package com.android.domain.executor

import io.reactivex.Scheduler

/**
 * Created by hassanalizadeh on 26,December,2019
 */
interface PostExecutionThread {
    fun scheduler(): Scheduler
}