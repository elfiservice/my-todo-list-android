package com.ajudanaweb.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var todoItem : EditText
    private lateinit var addButton : Button
    private lateinit var todoListView : ListView

    private var todoList = ArrayList<String>()
    private val fileHelper = FileHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponentsInScreen()
        setupAdapter()
    }

    private fun initComponentsInScreen() {
        todoItem = findViewById(R.id.inputToDoItem)
        addButton = findViewById(R.id.buttonAdd)
        todoListView = findViewById(R.id.todoList)
    }

    private fun setupAdapter() {
        todoList = fileHelper.readData(this)
        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1, todoList)

        todoListView.adapter = arrayAdapter

        addButton.setOnClickListener{
            val todoName : String = todoItem.text.toString()
            todoList.add(todoName)
            todoItem.setText("")
            fileHelper.writeData(todoList, applicationContext)
            arrayAdapter.notifyDataSetChanged()
        }
    }
}