package com.humaxdigital.ev_charging_station.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder <T, VB : ViewDataBinding>(var binding : VB) : RecyclerView.ViewHolder(binding.root) {
    fun setVaribale (id : Int, data : T){
//        binding.setVariable(id, data);
        binding.apply { setVariable(id, data) }
    }
}