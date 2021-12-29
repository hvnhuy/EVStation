package com.humaxdigital.ev_charging_station.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActiviy <VB : ViewDataBinding, VM : ViewModel>: AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayOutID(): Int

    abstract fun getViewModel(): Class<VM>

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayOutID())
        viewModel = ViewModelProvider(this).get(getViewModel())
        initView()
    }

    abstract fun onClick(view: View)
}