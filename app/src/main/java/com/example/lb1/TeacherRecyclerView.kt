package com.example.lb1

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeacherRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private val adapter: TeacherAdapter
    private val emptyTeacherList: List<Teacher> = emptyList()

    init {
        layoutManager = LinearLayoutManager(context)
        adapter = TeacherAdapter(context, emptyTeacherList)
        setAdapter(adapter)
    }

    fun setShops(teachers: List<Teacher>) {
        adapter.teacherList = teachers
        adapter.notifyDataSetChanged()
    }
}