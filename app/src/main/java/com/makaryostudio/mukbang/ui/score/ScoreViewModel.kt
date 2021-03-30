package com.makaryostudio.mukbang.ui.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.makaryostudio.mukbang.model.section.SectionData

class ScoreViewModel : ViewModel() {
    private val _cubeScore = MutableLiveData<Int>()
    private val _prismScore = MutableLiveData<Int>()
    private val _pyramidScore = MutableLiveData<Int>()
    private val _evaluationScore = MutableLiveData<Int>()

    val cubeScore: LiveData<Int>
        get() = _cubeScore
    val prismScore: LiveData<Int>
        get() = _prismScore
    val pyramidScore: LiveData<Int>
        get() = _pyramidScore
    val evaluationScore: LiveData<Int>
        get() = _evaluationScore

    private val listSection = SectionData.listSection

    init {
        _cubeScore.value = listSection[0].score
        _prismScore.value = listSection[1].score
        _pyramidScore.value = listSection[2].score
        _evaluationScore.value = listSection[3].score
    }
}