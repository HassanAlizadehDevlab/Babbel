package com.android.data.entity.mapper

import com.android.data.entity.model.local.WordEntity
import com.android.data.entity.model.remote.Word

/**
 * Define extensions to map remote objects to db entity objects.
 */

fun Word.map(): WordEntity = WordEntity(0, textEnglish, textSpanish)
fun List<Word>.map(): List<WordEntity> = map { it.map() }