package com.example.lb1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText

    private var operand1: Int = 0
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val button11: Button = findViewById(R.id.button11)
        val button12: Button = findViewById(R.id.button12)
        val button13: Button = findViewById(R.id.button13)
        val button14: Button = findViewById(R.id.button14)
        val button15: Button = findViewById(R.id.button15)

        val numberButtons = listOf(
            button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {
                editText.append(button.text)
            }
        }

        button11.setOnClickListener {
            performOperation("=")
        }
        button12.setOnClickListener {
            performOperation("+")
        }
        button13.setOnClickListener {
            performOperation("-")
        }
        button14.setOnClickListener {
            performOperation("*")
        }
        button15.setOnClickListener {
            performOperation("/")
        }

    }

    private fun performOperation(newOperator: String) {
        val input = editText.text.toString().toInt()
        when (operator) {
            null -> operand1 = input
            "=" -> operand1 = input
            "+" -> operand1 += input
            "-" -> operand1 -= input
            "*" -> operand1 *= input
            "/" -> operand1 /= input
        }
        operator = newOperator
        textView.text = operand1.toString()
        editText.text.clear()
    }
}
