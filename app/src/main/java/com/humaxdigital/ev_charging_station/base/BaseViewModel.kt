package com.humaxdigital.ev_charging_station.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel () {
    val empty = MutableLiveData<Boolean>().apply { value = false }

    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()
    val postDone = MutableLiveData<Boolean>().apply { value = false }
    val deleteDone = MutableLiveData<Boolean>().apply { value = false }
}