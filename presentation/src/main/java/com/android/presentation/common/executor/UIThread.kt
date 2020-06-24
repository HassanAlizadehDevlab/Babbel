package com.android.presentation.common.executor

import com.android.domain.executor.PostExecutionThread
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

/**
 * UI thread provider implementation.
 */
class UIThread @Inject constructor() : PostExecutionThread {

    override fun scheduler(): Scheduler = AndroidSchedulers.mainThread()

}