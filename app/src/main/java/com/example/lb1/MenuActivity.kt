package com.example.lb1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val textView: TextView = findViewById(R.id.textView2)
        val button: Button = findViewById(R.id.button)
        val logout: Button = findViewById(R.id.logout)
        val editText: EditText = findViewById(R.id.editText)
        val button1: Button = findViewById(R.id.button23)
        val button2: Button = findViewById(R.id.button25)
        logout.setOnClickListener {
            // Викликайте AuthActivity і закрийте всі попередні активіті
            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finishAffinity()
        }

        button1.setOnClickListener {
            val intent = Intent(this, Teachers::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, Couples::class.java)
            startActivity(intent)
        }
        button.setOnClickListener() {
            val value = getTextFromEditText(editText)
            textView.text = if (!value.isNullOrEmpty()) value else "no value"

            if (value?.lowercase() == "calc") {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Напиши calc для переходу на інше актівіті" , Toast.LENGTH_SHORT).show()
            }
        }
    }
        fun getTextFromEditText(textView:EditText):String? {
            return textView.text?.toString()
        }


}

