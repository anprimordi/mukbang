package com.makaryostudio.mukbang.model.materials

data class Materials(
    var thumbnail: Int = 0,
    var title: String = "",
    var fileSource: String = "",
    var completed: Boolean = false
)