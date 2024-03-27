package com.example.lb1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Teachers : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teachers)

        val log: Button = findViewById(R.id.logout)
        val button: Button = findViewById(R.id.button22)

        log.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        val teacherRecyclerView = findViewById<TeacherRecyclerView>(R.id.shopRecyclerView)
        val teachers = listOf(
            Teacher("Магазин 1", "Адреса 1", "123456789", "08:00", "18:00"),
            Teacher("Магазин 2", "Адреса 2", "987654321", "09:00", "19:00"),
            Teacher("Магазин 3", "Адреса 3", "555555555", "10:00", "20:00"),
            Teacher("Магазин 4", "Адреса 1", "123456789", "08:00", "18:00"),
            Teacher("Магазин 5", "Адреса 2", "987654321", "09:00", "19:00"),
            Teacher("Магазин 6", "Адреса 3", "555555555", "10:00", "20:00"),
        )
        teacherRecyclerView.setShops(teachers)

        button.setOnClickListener {
            val teacherAdapter = teacherRecyclerView.adapter as TeacherAdapter
            teacherAdapter.showAddTeacherDialog()
        }
    }
}