package com.android.domain.entity

import java.io.Serializable

data class ResultObject(
    val success: Byte,
    val all: Byte,
    val hint: String
): Serializable