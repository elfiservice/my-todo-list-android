package com.ajudanaweb.mytodolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    private val FILENAME = "listinfo.dat"

    fun writeData(item : ArrayList<String>, context : Context) {
        //MODE_PRIVATE = file available just for this App and not for out of this App
        val fos : FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)

        val oas = ObjectOutputStream(fos)
        oas.writeObject(item) //write to file
        oas.close()  //close the file
    }

    fun readData(context: Context) : ArrayList<String> {
        val itemList : ArrayList<String>
        val fis : FileInputStream = context.openFileInput(FILENAME)
        val ois = ObjectInputStream(fis)
        itemList = ois.readObject() as ArrayList<String>

        return itemList
    }
}