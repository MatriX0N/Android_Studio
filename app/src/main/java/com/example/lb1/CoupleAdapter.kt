package com.example.lb1

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoupleAdapter(private val context: Context, var coupleList: List<Couple>) :
    RecyclerView.Adapter<CoupleAdapter.CoupleViewHolder>() {

    inner class CoupleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)
        val weekdayTextView: TextView = itemView.findViewById(R.id.WeekdayTextView)
        val editButton: ImageButton = itemView.findViewById(R.id.editButton)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoupleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_couple, parent, false)
        return CoupleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoupleViewHolder, position: Int) {
        val currentItem = coupleList[position]
        holder.nameTextView.text = currentItem.name
        holder.numberTextView.text = currentItem.number
        holder.weekdayTextView.text = currentItem.weekday

        holder.editButton.setOnClickListener {
            openEditPopup(currentItem, position)
        }

        holder.deleteButton.setOnClickListener {
            deleteItem(position)
        }
    }

    override fun getItemCount() = coupleList.size

    fun showAddCoupleDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Add Couple")

        val view = LayoutInflater.from(context).inflate(R.layout.add_couple_dialog, null)

        val nameEditText = view.findViewById<EditText>(R.id.addNameEditText)
        val numberEditText = view.findViewById<EditText>(R.id.addNumberEditText)
        val weekdayEditText = view.findViewById<EditText>(R.id.addWeekdayEditText)

        builder.setView(view)

        builder.setPositiveButton("Add") { dialog, _ ->
            val name = nameEditText.text.toString()
            val number = numberEditText.text.toString()
            val weekday = weekdayEditText.text.toString()

            val newCouple = Couple(name, number, weekday)

            coupleList = coupleList + newCouple
            notifyDataSetChanged()

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun openEditPopup(couple: Couple, position: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Edit Couple")

        val view = LayoutInflater.from(context).inflate(R.layout.edit_couple_dialog, null)

        val nameEditText = view.findViewById<EditText>(R.id.editNameEditText)
        val numberEditText = view.findViewById<EditText>(R.id.editNumberEditText)
        val weekdayEditText = view.findViewById<EditText>(R.id.editWeekdayEditText)

        nameEditText.setText(couple.name)
        numberEditText.setText(couple.number)
        weekdayEditText.setText(couple.weekday)

        builder.setView(view)

        builder.setPositiveButton("Save") { dialog, _ ->
            val newName = nameEditText.text.toString()
            val newNumber = numberEditText.text.toString()
            val newWeekday = weekdayEditText.text.toString()

            val updatedCouple = Couple(newName, newNumber, newWeekday)

            val updatedList = coupleList.toMutableList()
            updatedList[position] = updatedCouple
            coupleList = updatedList.toList()
            notifyDataSetChanged()

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteItem(position: Int) {
        coupleList = coupleList.toMutableList().apply {
            removeAt(position)
        }
        notifyDataSetChanged()
    }
}
