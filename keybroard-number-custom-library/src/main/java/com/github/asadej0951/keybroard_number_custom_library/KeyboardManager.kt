package com.github.asadej0951.keybroard_number_custom_library

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ViewGroup

interface KeyboardManager {
    fun initView(
        context: Context,
        viewGroup: ViewGroup,
        textSize: Int,
        textColor: Int,
        text: String,
        sizeButton: Int,
        drawable: Drawable,
        marginButton : Int
    )

    fun setTextSize(size: Int)
    fun setTextColor(color: Int)
    fun setText(text: String)
    fun setSizeButton(sizeButton: Int)
    fun setBackground(drawable: Drawable)
    fun setMarginButton(marginButton :Int)
    fun setOnClickListener(onClick: ((String) -> Unit))
}