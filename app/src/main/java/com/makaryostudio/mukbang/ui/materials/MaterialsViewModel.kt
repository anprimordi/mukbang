package com.makaryostudio.mukbang.ui.materials

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MaterialsViewModel(materialsCode: Int) : ViewModel() {
    private val _code = MutableLiveData<Int>()
    val code: LiveData<Int>
        get() = _code

    init {
        _code.value = materialsCode

        when(code.value) {
            0 -> {
                
            }
        }
    }
}