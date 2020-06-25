package com.android.presentation.common.view

import androidx.annotation.StringRes

class MessageData(
    var message: String? = null,
    @StringRes
    var resource: Int? = null
)