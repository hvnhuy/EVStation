package com.humaxdigital.ev_charging_station.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter <T, VB : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder<T, VB>>() {
    var listData : ArrayList<T>? = ArrayList()
    lateinit  var mContext : Context
    lateinit var binding: VB

    abstract fun getLayoutId() : Int
    abstract fun getVaribaled() : Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, VB> {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), getLayoutId(), parent, false)
        return BaseViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, VB>, position: Int) {
        holder.setVaribale(getVaribaled(), listData!![position])
    }

    override fun getItemCount(): Int {
        return listData!!.count()
    }

    fun setNewListData(list : ArrayList<T>)  {
        listData!!.clear()
        listData!!.addAll(list)
        notifyDataSetChanged()
    }
    fun addItemToList (t : T) {
        listData!!.add(t)
        notifyDataSetChanged()
    }
    fun removeItemInList (t : T) {
        listData!!.remove(t)
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}