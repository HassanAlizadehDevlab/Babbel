package com.android.presentation.ui.starter.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.presentation.R
import com.android.presentation.common.view.BaseFragment

/**
 * Created by hassanalizadeh on 25,June,2020
 */
class StarterFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_starter, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    companion object {
        fun newInstance(): StarterFragment = StarterFragment()
    }

}