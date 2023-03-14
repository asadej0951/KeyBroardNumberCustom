package com.github.asadej0951.keybroard_number_custom_library

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import com.github.asadej0951.keybroard_number_custom_library.databinding.ViewKeybroardBinding


class KeyboardEvent : KeyboardManager {

    private lateinit var binding: ViewKeybroardBinding
    private lateinit var mFunctionViewKeyboardCustom: FunctionViewKeyboardCustom
    private val mArrayList = ArrayList<Button>()
    private lateinit var mContext: Context

    override fun initView(
        context: Context,
        viewGroup: ViewGroup,
        textSize: Int,
        textColor: Int,
        text: String,
        sizeButton: Int,
        drawable: Drawable,
        marginButton: Int,
        imageButton: Drawable?
    ) {
        binding = ViewKeybroardBinding.inflate(LayoutInflater.from(context), viewGroup, true)
        mContext = context
        mArrayList.add(binding.btn0)
        mArrayList.add(binding.btn1)
        mArrayList.add(binding.btn2)
        mArrayList.add(binding.btn3)
        mArrayList.add(binding.btn4)
        mArrayList.add(binding.btn5)
        mArrayList.add(binding.btn6)
        mArrayList.add(binding.btn7)
        mArrayList.add(binding.btn8)
        mArrayList.add(binding.btn9)
        mArrayList.add(binding.btnNull)
        mArrayList.add(binding.btnDelete)
        mFunctionViewKeyboardCustom = FunctionViewKeyboardCustom()
        setText(text)
        setTextSize(textSize)
        setSizeButton(sizeButton)
        setTextColor(textColor)
        setBackground(drawable)
        setMarginButton(marginButton)
        setImageButton(imageButton)

        imageButton?.let {
            binding.btnDelete.visibility = View.GONE
            binding.btnDeleteIcon.visibility = View.VISIBLE
        } ?: kotlin.run {
            binding.btnDelete.visibility = View.VISIBLE
            binding.btnDeleteIcon.visibility = View.GONE
        }
    }

    override fun setTextSize(size: Int) {
        mFunctionViewKeyboardCustom.setViewTextSize(mArrayList, size)
    }

    override fun setTextColor(@ColorInt color: Int) {
        val mTextColor = ColorStateList.valueOf(color)
        mFunctionViewKeyboardCustom.setViewColorText(mArrayList, mTextColor)
    }

    override fun setText(text: String) {
        binding.btnDelete.text = text
    }

    override fun setSizeButton(sizeButton: Int) {
        mFunctionViewKeyboardCustom.setViewHeightWidth(sizeButton, mArrayList,binding.btnDeleteIcon)
    }

    override fun setBackground(drawable: Drawable) {
        mFunctionViewKeyboardCustom.setViewBackground(drawable, mArrayList,binding.btnDeleteIcon)
    }

    override fun setMarginButton(marginButton: Int) {
        mFunctionViewKeyboardCustom.setViewMarginButton(marginButton, mArrayList,binding.btnDeleteIcon)
    }

    override fun setOnClickListener(onClick: (String) -> Unit) {
        mArrayList.map { button ->
            button.setOnClickListener {
                onClick.invoke(if (button != binding.btnDelete) button.text.toString() else "delete")
            }
        }
        binding.btnDeleteIcon.setOnClickListener {
            onClick.invoke("delete")
        }
    }

    override fun setImageButton(imageButton: Drawable?) {
        imageButton?.let {
            binding.btnDeleteIcon.setImageDrawable(imageButton)
        }
    }

}