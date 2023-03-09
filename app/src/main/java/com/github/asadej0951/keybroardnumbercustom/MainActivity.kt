package com.github.asadej0951.keybroardnumbercustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.github.asadej0951.keybroard_number_custom_library.KeyboardCustom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<AppCompatEditText>(R.id.edit_query)
        val keyboard = findViewById<KeyboardCustom>(R.id.keyboard)

        keyboard.setOnClickListener {
            editText.setText(it)
        }
    }
}