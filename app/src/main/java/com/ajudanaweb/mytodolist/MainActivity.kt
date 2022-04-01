package com.ajudanaweb.mytodolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

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

        todoListView.setOnItemClickListener { adapterView, view, position, l ->
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Delete Todo")
            alert.setMessage("Do you want to delete this ToDo item ?")
            alert.setCancelable(false)
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                todoList.removeAt(position)
                arrayAdapter.notifyDataSetChanged()
                fileHelper.writeData(todoList, applicationContext)
            })

            alert.create().show()
        }
    }
}