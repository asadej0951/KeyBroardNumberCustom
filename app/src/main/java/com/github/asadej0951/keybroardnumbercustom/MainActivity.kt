package com.github.asadej0951.keybroardnumbercustom

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.github.asadej0951.keybroard_number_custom_library.FormatCustom
import com.github.asadej0951.keybroard_number_custom_library.KeyboardCustom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText = findViewById<AppCompatEditText>(R.id.edit_query)
        val keyboard = findViewById<KeyboardCustom>(R.id.keyboard)
        val btn = findViewById<AppCompatButton>(R.id.btnMain)
        keyboard.connectWithEdittext(editText)
        btn.setOnClickListener {
            editText.error = "test test"
        }

//        keyboard.setFormatNumberPhone(true)

//        editText.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                editText.removeTextChangedListener(this)
//                editText.setText(FormatCustom().setFormat(format = "### ### ####",string = s.toString()))
//                editText.setSelection(editText.text.toString().length)
//
////                Log.i("checkIndex",FormatCustom().setFormat(string = s.toString()))
//                editText.addTextChangedListener(this)
//            }
//
//            override fun afterTextChanged(s: Editable?) {}
//        })


    }






}