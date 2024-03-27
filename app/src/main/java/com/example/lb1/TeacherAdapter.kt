package com.example.lb1

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter(private val context: Context, var teacherList: List<Teacher>) :
    RecyclerView.Adapter<TeacherAdapter.ShopViewHolder>() {
    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.phoneNumberTextView)
        val openTextView: TextView = itemView.findViewById(R.id.openTextView)
        val closeTextView: TextView = itemView.findViewById(R.id.closeTextView)
        val editButton: ImageButton = itemView.findViewById(R.id.editButton)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

    }
    override fun getItemCount(): Int {
        return teacherList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop, parent, false)
        return ShopViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val currentItem = teacherList[position]
        holder.nameTextView.text = currentItem.name
        holder.addressTextView.text = currentItem.address
        holder.phoneNumberTextView.text = currentItem.phoneNumber
        holder.openTextView.text = currentItem.open
        holder.closeTextView.text = currentItem.close

        holder.editButton.setOnClickListener {
            openEditPopup(holder.itemView.context, currentItem, position)
        }

        holder.deleteButton.setOnClickListener {
            deleteItem(position)
        }
    }

    fun showAddTeacherDialog() {
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle("Add Teacher")

        // Створення макету для поп-апу додавання викладача
        val view = LayoutInflater.from(this.context).inflate(R.layout.add_teacher_dialog, null)

        // Здійснюємо посилання на EditText для введення даних викладача
        val nameEditText = view.findViewById<EditText>(R.id.addNameEditText)
        val addressEditText = view.findViewById<EditText>(R.id.addAddressEditText)
        val phoneNumberEditText = view.findViewById<EditText>(R.id.addPhoneNumberEditText)
        val openEditText = view.findViewById<EditText>(R.id.addOpenEditText)
        val closeEditText = view.findViewById<EditText>(R.id.addCloseEditText)

        builder.setView(view)

        // Додавання кнопок для підтвердження та відміни дії
        builder.setPositiveButton("Add") { dialog, _ ->
            // Отримання даних з полів вводу
            val name = nameEditText.text.toString()
            val address = addressEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val open = openEditText.text.toString()
            val close = closeEditText.text.toString()

            // Створення нового викладача
            val newTeacher = Teacher(name, address, phoneNumber, open, close)

            // Додавання нового викладача до списку
            teacherList = teacherList + newTeacher

            // Оновлення відображення списку
            notifyDataSetChanged()

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }



    private fun openEditPopup(context: Context, teacher: Teacher, position: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Edit Shop")

        // Створення макету для поп-апу редагування
        val view = LayoutInflater.from(context).inflate(R.layout.edit_shop_dialog, null)

        // Заповнення полів в макеті даними магазину
        val nameEditText = view.findViewById<EditText>(R.id.editNameEditText)
        val addressEditText = view.findViewById<EditText>(R.id.editAddressEditText)
        val phoneNumberEditText = view.findViewById<EditText>(R.id.editPhoneNumberEditText)
        val openEditText = view.findViewById<EditText>(R.id.editOpenEditText)
        val closeEditText = view.findViewById<EditText>(R.id.editCloseEditText)

        nameEditText.setText(teacher.name)
        addressEditText.setText(teacher.address)
        phoneNumberEditText.setText(teacher.phoneNumber)
        openEditText.setText(teacher.open)
        closeEditText.setText(teacher.close)

        builder.setView(view)

        // Додавання кнопок для підтвердження та відміни дії
        builder.setPositiveButton("Save") { dialog, _ ->
            // Отримання змінених даних з полів
            val newName = nameEditText.text.toString()
            val newAddress = addressEditText.text.toString()
            val newPhoneNumber = phoneNumberEditText.text.toString()
            val newOpen = openEditText.text.toString()
            val newClose = closeEditText.text.toString()

            // Створення нового об'єкта Shop з оновленими даними
            val updatedTeacher = Teacher(newName, newAddress, newPhoneNumber, newOpen, newClose)

            // Оновлення даних магазину у списку
            val updatedList = teacherList.toMutableList()
            updatedList[position] = updatedTeacher
            teacherList = updatedList.toList()
            notifyDataSetChanged()

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun deleteItem(position: Int) {
        teacherList = teacherList.toMutableList().apply {
            this@apply.removeAt(position)
        }
        notifyDataSetChanged()
    }
}
