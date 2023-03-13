package com.github.asadej0951.keybroard_number_custom_library

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout

class KeyboardCustom : ConstraintLayout {

    private lateinit var manager: KeyboardManager

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        readAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        readAttrs(attrs)
    }

    private fun readAttrs(attrs: AttributeSet) {
        with(context.theme.obtainStyledAttributes(attrs, R.styleable.KeyboardCustom, 0, 0)) {
            inflateView(
                getTypeKeyboard(this),
                getDimensionPixelSize(
                    R.styleable.KeyboardCustom_text_size,
                    ViewGroup.LayoutParams.MATCH_PARENT
                ),
                getColor(
                    R.styleable.KeyboardCustom_text_color,
                    resources.getColor(androidx.cardview.R.color.cardview_light_background)
                ),
                getString(R.styleable.KeyboardCustom_text) ?: "0",
                getDimensionPixelSize(
                    R.styleable.KeyboardCustom_size_button,
                    0
                ),
                getDrawable(R.styleable.KeyboardCustom_background_button),
                getDimensionPixelSize(R.styleable.KeyboardCustom_margin_button, spToPx(5f, context))
            )
            recycle()
        }
    }

    private fun getTypeKeyboard(attrs: TypedArray): KeyboardType = KeyboardType.DefKeyboard

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun inflateView(
        type: KeyboardType,
        textSize: Int,
        textColor: Int,
        text: String,
        sizeButton: Int,
        drawable: Drawable?,
        marginButton: Int
    ) {
        manager = KeyboardEvent()
        removeAllViews()
        manager.initView(
            context,
            this,
            textSize,
            textColor,
            text,
            sizeButton,
            drawable ?: resources.getDrawable(androidx.cardview.R.color.cardview_dark_background),
            marginButton
        )
    }

    fun setSizeButton(sizeButton: Float) {
        manager.setSizeButton(convertDpToPixel(sizeButton, context).toInt())
    }

    private fun spToPx(sp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sp,
            context.resources.displayMetrics
        ).toInt()
    }

    private fun convertDpToPixel(dp: Float, context: Context?): Float {
        return if (context != null) {
            val resources = context.resources
            val metrics = resources.displayMetrics
            dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        } else {
            val metrics = Resources.getSystem().displayMetrics
            dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }

    fun setOnClickListener(callback: ((String) -> Unit)) {
        manager.setOnClickListener {
            callback.invoke(it)
        }
    }

    fun setTextSize(size: Int) {
        manager.setTextSize(size)
    }

    fun setTextColor(@ColorInt color: Int) {
        manager.setTextColor(color)
    }

    fun setText(text: String) {
        manager.setText(text)
    }

    fun setSizeButton(sizeButton: Int) {
        manager.setSizeButton(sizeButton)
    }

    fun setBackgroundButton(drawable: Drawable) {
        manager.setBackground(drawable)
    }

    fun setMarginButton(marginButton: Int) {
        manager.setMarginButton(marginButton)
    }

    fun connectWithEdittext(editText: AppCompatEditText) {
        editText.setOnTouchListener { v, event -> true }
        manager.setOnClickListener {
            var message = editText.text.toString()

            if (it != "delete") {
                message += it
            } else {
                if (message.isNotEmpty()) {
                    message = message.substring(0, message.length - 1)
                }
            }
            editText.setText(message)
        }
    }

}