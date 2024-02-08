package com.example.lb1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myImageView: ImageView = findViewById(R.id.imageView)
        val textV: TextView = findViewById(R.id.textView)
        val intent = Intent(this, Second::class.java)
        myImageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textV.text = "Kav"
            }
        })
        textV.setOnClickListener {
            if (textV.text == "Kav") {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Натисни на кавун", Toast.LENGTH_SHORT).show()
            }
        }
    }

}