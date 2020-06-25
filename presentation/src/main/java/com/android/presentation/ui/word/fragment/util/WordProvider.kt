package com.android.presentation.ui.word.fragment.util

import com.android.domain.entity.ResultObject
import com.android.domain.entity.WordObject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
interface WordProvider {
    fun setWords(words: List<WordObject>)
    fun getNewWordList(): List<WordObject>
    fun hasNext(): Boolean
    fun next(): WordObject
    fun skip()
    fun setResult(isMatch: Boolean)
    fun getSize(): Int
    fun getCurrentPosition(): Int
    fun getResult(): ResultObject
}