package com.android.data.entity.mapper

import com.android.data.entity.model.local.WordEntity
import com.android.data.entity.model.remote.Word
import com.android.domain.entity.WordObject

/**
 * Define extensions to map remote objects to db entity objects.
 */

fun WordObject.map(id: Int): WordEntity = WordEntity(textEnglish, textSpanish, passed)
fun List<WordObject>.map(): List<WordEntity> = mapIndexed { index, word -> word.map(index) }