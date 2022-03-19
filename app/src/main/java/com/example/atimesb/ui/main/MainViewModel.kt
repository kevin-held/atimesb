package com.example.atimesb.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var a = 0
    private var b = 0
    private var result: MutableLiveData<Int> = MutableLiveData()

    fun setA(value: Int){
        this.a = value
        result.setValue(a * b)
    }

    fun setB(value: Int) {
        this.b = value
        result.setValue(a * b)
    }

    fun getResult(): MutableLiveData<Int> {
        return result
    }
}