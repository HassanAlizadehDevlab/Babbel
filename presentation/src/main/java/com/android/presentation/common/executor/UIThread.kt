package com.android.presentation.common.executor

import com.android.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * UI thread provider implementation.
 */
class UIThread @Inject constructor() : PostExecutionThread {

    override fun scheduler(): Scheduler = AndroidSchedulers.mainThread()

}