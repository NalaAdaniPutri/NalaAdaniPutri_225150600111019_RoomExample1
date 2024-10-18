package com.example.nalaadaniputri_225150600111019_roomexample1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nalaadaniputri_225150600111019_roomexample1.database.DatabaseHelper

class AddItemActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val editText: EditText = findViewById(R.id.editTextItem)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)

        databaseHelper = DatabaseHelper(this)

        buttonAdd.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                databaseHelper.addItem(newItem)
                Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter an item", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
