package com.android.presentation.ui.congratulation.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.domain.entity.ResultObject
import com.android.presentation.R
import com.android.presentation.common.Constants
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.ui.congratulation.CongratulationNavigator
import kotlinx.android.synthetic.main.fragment_congratulation.*
import javax.inject.Inject

class CongratulationFragment : BaseFragment() {

    @Inject
    lateinit var navigator: CongratulationNavigator


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_congratulation, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        buttonContinue.setOnClickListener {
            navigator.showWordPage()
        }

        // Show result in view
        val result = arguments?.getSerializable(Constants.PARAM) as? ResultObject ?: return
        txtPassedWords.text = "${result.success}/${result.all}"
        txtHint.text = result.hint
    }

    companion object {
        fun newInstance(result: ResultObject): CongratulationFragment = CongratulationFragment()
            .apply {
                arguments = Bundle().apply {
                    putSerializable(Constants.PARAM, result)
                }
            }
    }

}