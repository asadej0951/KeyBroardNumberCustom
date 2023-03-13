package com.github.asadej0951.keybroard_number_custom_library

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.marginBottom

class FunctionViewKeyboardCustom {
    fun setViewHeightWidth(
        sizeButton: Int,
        mArrayList: ArrayList<Button>
    ) {
        if (sizeButton != 0){
            mArrayList.map {view ->
                val layoutParams: ViewGroup.LayoutParams = view.layoutParams
                layoutParams.width = sizeButton
                layoutParams.height = sizeButton
                view.layoutParams = layoutParams
            }
        }
    }

    fun setViewMarginButton(
        marginButton: Int,
        mArrayList: ArrayList<Button>
    ) {
        if (marginButton != 0){
            mArrayList.map {view ->
                val param = view.layoutParams as ViewGroup.MarginLayoutParams
                param.setMargins(marginButton,marginButton,marginButton,marginButton)
                view.layoutParams = param
            }
        }
    }

    fun setViewColorText(mArrayList: ArrayList<Button>, color: ColorStateList) {
        mArrayList.map {
            it.setTextColor(color)
        }
    }

    fun setViewBackground(drawable: Drawable, mArrayList: ArrayList<Button>) {
        mArrayList.map {
            it.background = drawable
        }
    }

    fun setViewTextSize(mArrayList: ArrayList<Button>, size: Int) {
        mArrayList.map {
            it.textSize = size.toFloat()
        }
    }
}