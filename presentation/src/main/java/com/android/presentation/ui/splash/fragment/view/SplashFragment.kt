package com.android.presentation.ui.splash.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.presentation.R
import com.android.presentation.common.extension.observe
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.extension.visibleOrGone
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.splash.SplashNavigator
import com.android.presentation.ui.splash.fragment.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 24,June,2020
 */
class SplashFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    @Inject
    lateinit var navigator: SplashNavigator
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
        observe(viewModel.wordsAreReady, ::handleNavigation)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        retryButton.setOnClickListener {
            handleWidgetsVisibility(true)
            viewModel.getWords()
        }
    }

    private fun handleNavigation(status: Boolean) {
        if (status) {
            navigator.showStarterPage()
            return
        }
        handleWidgetsVisibility(status)
    }

    private fun handleWidgetsVisibility(status: Boolean) {
        retryButton.visibleOrGone(!status)
        progressBarLoading.visibleOrGone(status)
    }

    companion object {
        fun newInstance(): SplashFragment = SplashFragment()
    }
}