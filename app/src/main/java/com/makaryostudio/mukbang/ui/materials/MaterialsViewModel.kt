package com.makaryostudio.mukbang.ui.materials

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.makaryostudio.mukbang.model.materials.MaterialsData

class MaterialsViewModel(materialsCode: Int) : ViewModel() {
    private val _code = MutableLiveData<Int>()
    private val code: LiveData<Int>
        get() = _code

    private val _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private val _pdfSource = MutableLiveData<String>()
    val pdfSource: LiveData<String>
        get() = _pdfSource

    init {
        _code.value = materialsCode

        _title.value = MaterialsData.listMaterials[code.value!!].title
        _pdfSource.value = MaterialsData.listMaterials[materialsCode].fileSource
    }

    fun completeMaterials(code: Int) {
        MaterialsData.listMaterials[code].completed = true
    }
}