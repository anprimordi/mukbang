package com.makaryostudio.mukbang.utils

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.view.View

class DragShadowBuilder(v: View) : View.DragShadowBuilder(v) {
    private val shadow = ColorDrawable(Color.LTGRAY)

    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val width: Int = (view.width / 1.2F).toInt()
        val height: Int = (view.height / 1.2F).toInt()

        shadow.setBounds(0, 0, width, height)
        size.set(width, height)
        touch.set(width / 2, height / 2)
    }

    override fun onDrawShadow(canvas: Canvas) {
        shadow.draw(canvas)
    }
}