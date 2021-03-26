package com.makaryostudio.mukbang.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.makaryostudio.mukbang.model.quiz.Quiz
import com.makaryostudio.mukbang.model.quiz.QuizData
import com.makaryostudio.mukbang.model.section.Section
import com.makaryostudio.mukbang.model.section.SectionData
import com.makaryostudio.mukbang.utils.QuizCodes

class QuizViewModel(code: Int) : ViewModel() {
    var currentNumber = 0
    private var _code = MutableLiveData<Int>()

    private var _number = MutableLiveData<Int>()
    private var _totalQuestion = MutableLiveData<Int>()
    private var _question = MutableLiveData<String>()
    private var _optionA = MutableLiveData<String>()
    private var _optionB = MutableLiveData<String>()
    private var _optionC = MutableLiveData<String>()
    private var _optionD = MutableLiveData<String>()
    private var _key = MutableLiveData<String>()
    private var _explanation = MutableLiveData<String>()

    private var _eventQuestCompleted = MutableLiveData<Boolean>()
    private val _score = MutableLiveData<Int>()

    val code: LiveData<Int>
        get() = _code

    val number: LiveData<Int>
        get() = _number
    val totalQuest: LiveData<Int>
        get() = _totalQuestion
    val question: LiveData<String>
        get() = _question
    val optionA: LiveData<String>
        get() = _optionA
    val optionB: LiveData<String>
        get() = _optionB
    val optionC: LiveData<String>
        get() = _optionC
    val optionD: LiveData<String>
        get() = _optionD
    val key: LiveData<String>
        get() = _key
    val explanation: LiveData<String>
        get() = _explanation

    val eventQuestCompleted: LiveData<Boolean>
        get() = _eventQuestCompleted
    val score: LiveData<Int>
        get() = _score

    private val listQuizQuest: MutableList<Quiz>
    private val listSection = SectionData.listSection

    init {
        listQuizQuest = QuizData.allQuiz[code]
        _code.value = code
        _number.value = 0
        _totalQuestion.value = listQuizQuest.size
        _question.value = ""
        _optionA.value = ""
        _optionB.value = ""
        _optionC.value = ""
        _optionD.value = ""
        _key.value = ""
        _explanation.value = ""
        _score.value = 0

        showQuestion(listQuizQuest[currentNumber])
    }

    private fun showQuestion(quiz: Quiz) {
        _question.value = quiz.question
        _optionA.value = quiz.optionA
        _optionB.value = quiz.optionB
        _optionC.value = quiz.optionC
        _optionD.value = quiz.optionD
        _key.value = quiz.key
        _explanation.value = quiz.explanation
    }

    fun nextQuestion() {
        if (currentNumber + 1 < totalQuest.value!!) {
            _number.value = _number.value!!.plus(1)
            showQuestion(listQuizQuest[currentNumber++])
        } else {
            onQuest()
        }
    }

    fun addScore() {
        _score.value = _score.value!!.plus(1)
    }

    fun onQuestComplete(code: Int, score: Int): Section {
        listSection[code] = when (code) {
            QuizCodes.CUBE -> Section("Kubus", score)
            QuizCodes.PRISM -> Section("Prisma", score)
            QuizCodes.PYRAMID -> Section("Limas", score)
            QuizCodes.FINAL -> Section("Evaluasi", score)
            else -> Section()
        }
        _eventQuestCompleted.value = false
        return listSection[code]
    }

    private fun onQuest() {
        _eventQuestCompleted.value = true
    }
}