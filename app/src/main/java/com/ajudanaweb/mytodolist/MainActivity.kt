package com.ajudanaweb.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var todoItem : EditText
    lateinit var addButton : Button
    lateinit var todoList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findAndInit()
    }

    private fun findAndInit() {
        todoItem = findViewById(R.id.inputToDoItem)
        addButton = findViewById(R.id.buttonAdd)
        todoList = findViewById(R.id.todoList)
    }
}