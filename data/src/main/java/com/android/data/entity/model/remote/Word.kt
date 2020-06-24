package com.android.data.entity.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Remote API response
 */
data class Word(
    @SerializedName("text_eng")
    val textEnglish: String,
    @SerializedName("text_spa")
    val textSpanish: String
)