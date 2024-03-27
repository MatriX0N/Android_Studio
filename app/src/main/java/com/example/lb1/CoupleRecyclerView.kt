package com.example.lb1

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoupleRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private val adapter: CoupleAdapter
    private val emptyCoupleList: List<Couple> = emptyList()

    init {
        layoutManager = LinearLayoutManager(context)
        adapter = CoupleAdapter(context, emptyCoupleList)
        setAdapter(adapter)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCouples(couples: List<Couple>) {
        adapter.coupleList = couples
        adapter.notifyDataSetChanged()
    }
}
