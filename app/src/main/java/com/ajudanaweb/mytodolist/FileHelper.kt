package com.ajudanaweb.mytodolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val FILENAME = "listinfo.dat"

    fun writeData(item : ArrayList<String>, context : Context) {
        //MODO_PRIVATE = file available just for this App and not for out of this App
        var fos : FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)

        var oas = ObjectOutputStream(fos)
        oas.writeObject(item) //write to file
        oas.close()  //close the file
    }

    fun readData(context: Context) : ArrayList<String> {
        var itemList : ArrayList<String>
        var fis : FileInputStream = context.openFileInput(FILENAME)
        var ois = ObjectInputStream(fis)
        itemList = ois.readObject() as ArrayList<String>

        return itemList
    }
}