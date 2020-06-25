package com.android.presentation.ui.word.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.domain.entity.ResultObject
import com.android.domain.entity.WordObject
import com.android.presentation.R
import com.android.presentation.common.extension.observe
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.word.WordNavigator
import com.android.presentation.ui.word.fragment.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.fragment_word.*
import javax.inject.Inject

class WordFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var navigator: WordNavigator

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
        observe(viewModel.timeCounter, ::observeTimeCounter)
        observe(viewModel.wordCounter, ::observeWordCounter)
        observe(viewModel.currentWord, ::observeWord)
        observe(viewModel.finish, ::observeFinish)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_word, container, false)


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        // Click listeners
        buttonTrue.setOnClickListener {
            viewModel.setAnswerTrue()
        }

        buttonFalse.setOnClickListener {
            viewModel.setAnswerFalse()
        }
    }

    private fun observeWord(word: WordObject) {
        parent.progress = 0F
        parent.transitionToEnd()

        txtOriginalText.text = word.textEnglish
        txtTranslationText.text = word.textSpanish
    }

    private fun observeTimeCounter(second: Byte) {
        txtTimeCounter.text = "0:0$second"
    }

    private fun observeWordCounter(wordCounter: String) {
        txtWordCounter.text = wordCounter
    }

    private fun observeFinish(result: ResultObject) {
        navigator.showCongratulation(result)
    }


    companion object {
        fun newInstance(): WordFragment = WordFragment()
    }

}