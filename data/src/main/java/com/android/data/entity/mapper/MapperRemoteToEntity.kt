package com.android.data.entity.mapper

import com.android.data.entity.model.local.WordEntity
import com.android.data.entity.model.remote.Word

/**
 * Define extensions to map remote objects to db entity objects.
 */

fun Word.map(id: Int): WordEntity = WordEntity(id, textEnglish, textSpanish, false)
fun List<Word>.map(): List<WordEntity> = mapIndexed { index, word -> word.map(index) }