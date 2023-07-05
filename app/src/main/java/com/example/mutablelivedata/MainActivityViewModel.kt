package com.example.mutablelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(starting:Int) : ViewModel() {
    var total = MutableLiveData<Int>()
    init {
        total.value=starting
    }

    fun setTotal(input:Int){
        total.value = (total.value)?.plus(input)
    }
}
