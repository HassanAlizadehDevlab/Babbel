package com.android.data.entity.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The [WordEntity] is a table for persist words in it.
 */
@Entity(tableName = "word")
data class WordEntity(
    @PrimaryKey
    val id: Int,
    val textEnglish: String,
    val textSpanish: String
)