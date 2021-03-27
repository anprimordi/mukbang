package com.makaryostudio.mukbang.model.question

data class Question(
    var question: String = "",
    var optionA: String = "",
    var optionB: String = "",
    var optionC: String = "",
    var optionD: String = "",
    var key: String = "",
    var explanation: String = ""
)
