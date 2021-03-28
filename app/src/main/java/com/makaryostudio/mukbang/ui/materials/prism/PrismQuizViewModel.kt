package com.makaryostudio.mukbang.ui.materials.prism

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrismQuizViewModel : ViewModel() {
    val questionOneDrop = MutableLiveData<String>()
    val questionOne: LiveData<String>
        get() = questionOneDrop

    val questionTwoDrop = MutableLiveData<String>()
    val questionTwo: LiveData<String>
        get() = questionTwoDrop

    val questionThreeDrop = MutableLiveData<String>()
    val questionThree: LiveData<String>
        get() = questionThreeDrop

    val questionFourDrop = MutableLiveData<String>()
    val questionFour: LiveData<String>
        get() = questionFourDrop

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
        questionOneDrop.value = ""
        questionTwoDrop.value = ""
        questionThreeDrop.value = ""
        questionFourDrop.value = ""
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