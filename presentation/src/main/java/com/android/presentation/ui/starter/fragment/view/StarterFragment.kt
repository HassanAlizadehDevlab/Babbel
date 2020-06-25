package com.android.presentation.ui.starter.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.presentation.R
import com.android.presentation.common.extension.enable
import com.android.presentation.common.extension.gone
import com.android.presentation.common.extension.observe
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.starter.StarterNavigator
import com.android.presentation.ui.starter.fragment.viewmodel.StarterViewModel
import kotlinx.android.synthetic.main.fragment_starter.*
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class StarterFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var navigator: StarterNavigator

    private lateinit var viewModel: StarterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
        observe(viewModel.passedWordAvailability, ::passedWordsAvailability)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_starter, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        buttonNext.setOnClickListener {
            navigator.showWordPage()
        }
    }

    private fun passedWordsAvailability(available: Boolean) {
        progressBarLoading.gone()

        buttonNext.text = if (available) {
            getString(R.string.continue_)
        } else {
            getString(R.string.start)
        }

        buttonNext.enable()
    }

    companion object {
        fun newInstance(): StarterFragment = StarterFragment()
    }

}