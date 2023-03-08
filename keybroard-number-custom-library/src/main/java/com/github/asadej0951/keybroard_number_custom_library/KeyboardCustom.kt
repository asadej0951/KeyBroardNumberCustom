package com.github.asadej0951.keybroard_number_custom_library

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class KeyboardCustom @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var mContext: Context? = null
    private var btn1: AppCompatButton? = null
    private var btn2: AppCompatButton? = null
    private var btn3: AppCompatButton? = null
    private var btn4: AppCompatButton? = null
    private var btn5: AppCompatButton? = null
    private var btn6: AppCompatButton? = null
    private var btn7: AppCompatButton? = null
    private var btn8: AppCompatButton? = null
    private var btn9: AppCompatButton? = null
    private var btn0: AppCompatButton? = null
    private var btnDelete: AppCompatButton? = null

    private val onClickButton = MutableLiveData<String>()

    private var textOdl = ""

    init {
        mContext = context
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.view_keybroard, this)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnDelete = findViewById(R.id.btnDelete)

        setEventButton()

    }

    private fun setEventButton() {
        btn1?.let { button ->
            onClickListener(button)
        }
        btn2?.let { button ->
            onClickListener(button)
        }
        btn3?.let { button ->
            onClickListener(button)
        }
        btn4?.let { button ->
            onClickListener(button)
        }
        btn5?.let { button ->
            onClickListener(button)
        }
        btn6?.let { button ->
            onClickListener(button)
        }
        btn7?.let { button ->
            onClickListener(button)
        }
        btn8?.let { button ->
            onClickListener(button)
        }
        btn9?.let { button ->
            onClickListener(button)
        }
        btn0?.let { button ->
            onClickListener(button)
        }
        btnDelete?.let { button ->
            button.setOnClickListener {
                onClickButton.value = deleteText()
            }
        }
    }

    private fun onClickListener(button: AppCompatButton) {
        button.setOnClickListener {
            onClickButton.value = addText(button.text.toString())
        }
    }

    fun setOnClickListener(callback: ((String) -> Unit)) {
        mContext?.let {
            onClickButton.observe(it as LifecycleOwner, Observer {
                callback.invoke(textOdl)
            })
        }
    }

    private fun addText(text: String): String {
        textOdl += text
        return textOdl
    }

    private fun deleteText(): String {
        textOdl = textOdl.substring(0, textOdl.length - 1)
        return textOdl
    }


}