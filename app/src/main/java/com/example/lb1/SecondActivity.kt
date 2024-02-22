package com.example.lb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView: TextView = findViewById(R.id.textView2)
        val button: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)
        button.setOnClickListener() {
            val value = getTextFromEditText(editText)
            textView.text = if (!value.isNullOrEmpty()) value else "no value"

            if (value.equals("calc")) {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)
            }
        }
    }
        fun getTextFromEditText(textView:EditText):String? {
            return textView.text?.toString()
        }


}

