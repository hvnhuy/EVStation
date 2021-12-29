package com.humaxdigital.ev_charging_station.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel> : Fragment () {

    protected lateinit var binding : VB
    protected lateinit var viewModel : VM

    @LayoutRes
    abstract fun getLayOutID() : Int

    abstract fun getViewModel() : Class<VM>
    abstract fun initView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayOutID(), container, false)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
        initView()
        return binding.root
    }

}