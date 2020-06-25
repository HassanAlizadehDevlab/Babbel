package com.android.domain.entity

import java.io.Serializable

/**
 * Created by hassanalizadeh on 25,June,2020
 */
data class ResultObject(
    val success: Byte,
    val all: Byte,
    val hint: String
): Serializable