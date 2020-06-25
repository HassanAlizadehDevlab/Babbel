package com.android.presentation.ui.word.fragment.util

import com.android.domain.entity.ResultObject
import com.android.domain.entity.WordObject
import javax.inject.Inject
import kotlin.random.Random

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class WordProvider2020 @Inject constructor() : WordProvider {

    private lateinit var words: List<WordObject>
    private lateinit var newWords: MutableList<WordObject>
    private lateinit var currentWord: WordObject
    private var currentIndex: Int = 0

    override fun setWords(words: List<WordObject>) {
        this.words = words
        newWords = mutableListOf()
        currentIndex = 0
    }

    override fun hasNext(): Boolean {
        return words.size != currentIndex
    }

    override fun next(): WordObject {
        currentWord = WordObject(
            words[currentIndex].id,
            words[currentIndex].textEnglish,
            getTranslation().invoke()
        )
        return currentWord
    }

    override fun skip() {
        newWords.add(words[currentIndex])
        currentIndex++
    }

    override fun setResult(isMatch: Boolean) {
        if (currentWord.textSpanish == words[currentIndex].textSpanish && isMatch)
            newWords.add(currentWord.apply { passed = true })
        else newWords.add(currentWord.apply { passed = false })

        currentIndex++
    }

    override fun getSize(): Int {
        if (words.isNullOrEmpty()) return 0
        return words.size
    }

    override fun getCurrentPosition(): Int {
        return currentIndex + 1
    }

    override fun getResult(): ResultObject {
        val success = newWords.count { it.passed }
        val hint = when {
            success > 5 -> "Congratulation \nThat was perfect!"
            success > 3 -> "That was good!"
            else -> "Not bad!!"
        }

        return ResultObject(
            success = success.toByte(),
            all = newWords.size.toByte(),
            hint = hint
        )
    }


    // With 80% possibility the word is match with translation
    private fun getTranslation(): () -> String = {
        if (Random.nextDouble() < 0.8)
            words[currentIndex].textSpanish
        else
            words[Random.nextInt(0, words.size - 1)].textSpanish
    }

}