package com.android.presentation.ui.word.fragment.view

import android.os.Bundle
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.word.fragment.viewmodel.WordViewModel
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class WordFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
    }


    companion object {
        fun newInstance(): WordFragment = WordFragment()
    }

}