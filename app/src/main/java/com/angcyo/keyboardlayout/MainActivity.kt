package com.angcyo.keyboardlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.angcyo.uiview.widget.KeyboardLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)
        val keyboardLayout: KeyboardLayout = findViewById(R.id.keyboard_layout)
        keyboardLayout.onKeyboardInputListener = object : KeyboardLayout.OnKeyboardInputListener {
            override fun onKeyboardInput(key: String, isDel: Boolean) {
                textView.text = if (isDel) {
                    "回退"
                } else {
                    key
                }
            }
        }
    }
}
