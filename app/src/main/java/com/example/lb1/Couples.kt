package com.example.lb1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Couples : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couples)

        val log: Button = findViewById(R.id.logout)
        val button: Button = findViewById(R.id.button24)

        log.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        val coupleRecyclerView = findViewById<CoupleRecyclerView>(R.id.coupleRecyclerView)
        val couples = listOf(
            Couple("КПЗ", "2-3", "Понеділок"),
            Couple("ГДК", "2", "Вівторок"),
            Couple("ОКМ", "2", "Середа"),
            Couple("МП", "1-2", "Четвер"),
            Couple("КПЗ", "2-4", "П'ятниця"),
        )
        coupleRecyclerView.setCouples(couples)

        button.setOnClickListener {
            val coupleAdapter = coupleRecyclerView.adapter as CoupleAdapter
            coupleAdapter.showAddCoupleDialog()
        }
    }
}