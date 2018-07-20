package com.angcyo.keyboardlayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableStringBuilder
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

        val spannableStringBuilder = SpannableStringBuilder("前\n面默认测\n试文本")
        spannableStringBuilder.setSpan(ShapeSpan(Color.GRAY,
                20 * resources.displayMetrics.density).apply {
            paddingLeft = (6 * resources.displayMetrics.density).toInt()
            paddingRight = paddingLeft
            paddingTop = paddingLeft / 2
            paddingBottom = paddingTop

            marginLeft = (4 * resources.displayMetrics.density).toInt()
            marginRight = marginLeft
            marginTop = marginLeft / 2
            marginBottom = marginTop

            textColor = Color.RED
        },
                3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableStringBuilder
    }
}
