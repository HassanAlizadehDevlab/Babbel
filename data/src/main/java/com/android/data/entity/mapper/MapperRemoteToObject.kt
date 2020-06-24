package com.android.data.entity.mapper

import com.android.data.entity.model.remote.Word
import com.android.domain.executor.entity.WordObject

/**
 * Define extensions to map remote objects to domain objects.
 */

fun Word.map(): WordObject = WordObject(textEnglish, textSpanish)
fun List<Word>.map(): List<WordObject> = map { it.map() }