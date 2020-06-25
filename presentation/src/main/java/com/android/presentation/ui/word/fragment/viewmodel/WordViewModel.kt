package com.android.presentation.ui.word.fragment.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.android.domain.entity.ResultObject
import com.android.domain.entity.WordObject
import com.android.domain.usecase.word.LoadWordsUseCase
import com.android.domain.usecase.word.UpdateWordsUseCase
import com.android.presentation.common.view.BaseViewModel
import com.android.presentation.ui.word.fragment.util.WordProvider
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class WordViewModel @Inject constructor(
    private val loadWordsUseCase: LoadWordsUseCase,
    private val updateWordsUseCase: UpdateWordsUseCase,
    private val wordProvider: WordProvider
) : BaseViewModel() {

    val timeCounter = MutableLiveData<Byte>()
    val wordCounter = MutableLiveData<String>()
    val currentWord = MutableLiveData<WordObject>()
    val finish = MutableLiveData<ResultObject>()

    private var timer: CountDownTimer


    init {
        // Setup timer
        timer = object : CountDownTimer(MAX_TIME, SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                timeCounter.value = (millisUntilFinished / SECOND).toByte()
            }

            override fun onFinish() {
                wordProvider.skip()
                selectNextWord()
            }
        }

        // Load bunch of words
        loadWordsUseCase.invoke(WORD_COUNT)
            .subscribe({
                setWords(it)
            }, {})
            .track()

        currentWord.observeForever {
            startTimeCounter()
            setWordIndex()
        }
    }

    private fun setWords(items: List<WordObject>) {
        wordProvider.setWords(items)
        selectNextWord()
    }

    private fun selectNextWord() {
        if (wordProvider.hasNext())
            currentWord.value = wordProvider.next()
        else {
            updateWordsUseCase.invoke(wordProvider.getNewWordList())
                .subscribe({
                    finish.value = wordProvider.getResult()
                }, {
                    finish.value = wordProvider.getResult()
                })
                .track()
        }
    }

    private fun setWordIndex() {
        wordCounter.value = "${wordProvider.getCurrentPosition()}/${wordProvider.getSize()}"
    }

    private fun startTimeCounter() {
        timer.start()
    }

    private fun stopTimeCounter() {
        timer.cancel()
    }

    fun setAnswerTrue() {
        wordProvider.setResult(true)
        stopTimeCounter()
        selectNextWord()
    }

    fun setAnswerFalse() {
        wordProvider.setResult(false)
        stopTimeCounter()
        selectNextWord()
    }


    companion object {
        const val WORD_COUNT = 10
        private const val MAX_TIME = 10000L
        private const val SECOND = 1000L
    }

}