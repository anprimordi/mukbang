package com.makaryostudio.mukbang.ui.materials.prism

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrismQuizViewModel : ViewModel() {
    val _question = MutableLiveData<String>()
    val question: LiveData<String>
        get() = _question

    val keyOneDrop = MutableLiveData<String>()
    val keyOne: LiveData<String>
        get() = keyOneDrop

    val keyTwoDrop = MutableLiveData<String>()
    val keyTwo: LiveData<String>
        get() = keyTwoDrop

    val keyThreeDrop = MutableLiveData<String>()
    val keyThree: LiveData<String>
        get() = keyThreeDrop

    val keyFourDrop = MutableLiveData<String>()
    val keyFour: LiveData<String>
        get() = keyFourDrop

    private val _answerOne = MutableLiveData<String>()
    val answerOne: LiveData<String>
        get() = _answerOne

    private val _answerTwo = MutableLiveData<String>()
    val answerTwo: LiveData<String>
        get() = _answerTwo

    private val _answerThree = MutableLiveData<String>()
    val answerThree: LiveData<String>
        get() = _answerThree

    private val _answerFour = MutableLiveData<String>()
    val answerFour: LiveData<String>
        get() = _answerFour

//    private val _answerOneDrop = MutableLiveData<String>()
//    val answerOneDrop: LiveData<String>
//        get() = _answerOneDrop
//
//    private val _answerTwoDrop = MutableLiveData<String>()
//    val answerTwoDrop: LiveData<String>
//        get() = _answerTwoDrop
//
//    private val _answerThreeDrop = MutableLiveData<String>()
//    val answerThreeDrop: LiveData<String>
//        get() = _answerThreeDrop
//
//    private val _answerFourDrop = MutableLiveData<String>()
//    val answerFourDrop: LiveData<String>
//        get() = _answerFourDrop

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    init {
        _question.value =
            "Perhatikan model prisma dibawah ini dan cocokkan dengan jaring-jaring yang sebangun! (drag and drop)"
        keyOneDrop.value = ""
        keyTwoDrop.value = ""
        keyThreeDrop.value = ""
        keyFourDrop.value = ""
        _answerOne.value = "Prisma segi lima"
        _answerTwo.value = "Prisma segi delapan"
        _answerThree.value = "Prisma segi tiga"
        _answerFour.value = "Prisma segi empat"
        _score.value = 0
    }

    fun addScore() {
        _score.value = (_score.value!!.plus(1))
    }

    fun resetScore() {
        _score.value = 0
    }
}