package com.makaryostudio.mukbang.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class QuizViewModelFactory(
    private val code: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(code) as T
        }
        throw IllegalArgumentException("unknown viewmodel")
    }
}