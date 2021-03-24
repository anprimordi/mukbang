package com.makaryostudio.mukbang.ui.materials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MaterialsViewModelFactory(
    private val materialsCode: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaterialsViewModel::class.java)) {
            return MaterialsViewModel(materialsCode) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}