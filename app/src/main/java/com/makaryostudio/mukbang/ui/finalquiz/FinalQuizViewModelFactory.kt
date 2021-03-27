package com.makaryostudio.mukbang.ui.finalquiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class FinalQuizViewModelFactory(
    private val code: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FinalQuizViewModel::class.java)) {
            return FinalQuizViewModel(code) as T
        }
        throw IllegalArgumentException("unknown viewmodel")
    }
}