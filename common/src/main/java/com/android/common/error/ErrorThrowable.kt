package com.android.common.error

/**
 * Created by hassanalizadeh on 12,March,2019
 */
class ErrorThrowable(
    val code: Int,
    message: String?
) : Throwable(message) {

    constructor(code: Int) : this(code, null)
}