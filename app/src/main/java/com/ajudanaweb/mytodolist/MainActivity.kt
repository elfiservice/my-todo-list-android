package com.ajudanaweb.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var todoItem : EditText
    lateinit var addButton : Button
    lateinit var todoListView : ListView

    val todoList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponentsInScreen()
    }

    private fun initComponentsInScreen() {
        todoItem = findViewById(R.id.inputToDoItem)
        addButton = findViewById(R.id.buttonAdd)
        todoListView = findViewById(R.id.todoList)
    }
}