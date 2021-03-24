package com.makaryostudio.mukbang.model.quiz

data class Quiz(
    var question: String = "",
    var optionA: String = "",
    var optionB: String = "",
    var optionC: String = "",
    var optionD: String = "",
    var optionE: String = "",
    var key: String = "",
    var explanation: String = ""
)
