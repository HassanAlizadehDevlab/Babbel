package com.android.data.entity.mapper

import com.android.data.entity.model.local.WordEntity
import com.android.domain.executor.entity.WordObject

/**
 * Define extensions to map db entity objects to domain object.
 */

fun WordEntity.map(): WordObject = WordObject(textEnglish, textSpanish)
fun List<WordEntity>.map(): List<WordObject> = map { it.map() }