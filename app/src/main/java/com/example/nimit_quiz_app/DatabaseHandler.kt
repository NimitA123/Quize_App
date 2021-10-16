package com.example.nimit_quiz_app



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

//SQLiteOpenHelper class is responsible for creating data in sql database
class DatabaseHandler(val context: Context):SQLiteOpenHelper(context, "QuizeApp", null, 1) {

    companion object {
        val TABLE_NAME = "Journal_Table"
        val ID = "id"
        val Question = "Question"
        val OptionA = "optionA"
        val OptionB = "optionB"
        val OptionC = "optionC"
        val OptionD = "optionD"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery:String = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY, $Question TEXT, $OptionA " +
                "TEXT, $OptionB TEXT, $OptionC TEXT, $OptionD TEXT)"
        //sqliteDatabase obj run query on database
        db?.execSQL(createQuery)
    }
    fun insertRoutine(question:String, questionA: String,  questionB: String, questionC:String, questionD:String){
        val db = writableDatabase
        val value = ContentValues()
        value.put(Question, question)
        value.put(OptionA, questionA)
        value.put(OptionB, questionB)
        value.put(OptionC, questionC)
        value.put(OptionD, questionD)
        val id = db.insert(TABLE_NAME, null, value)
        if(id.toInt()==-1){
            //Error
            Toast.makeText(context, "Data Not Insert SuccessFully", Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(context, "Data Insert SuccessFully", Toast.LENGTH_LONG).show()
        }


    }

    fun Nimit() : MutableList<RoutainModel> {
        val listRountain : MutableList<RoutainModel> = mutableListOf<RoutainModel>()
        val db  = readableDatabase
        val query  = "SELECT * FROM $TABLE_NAME"
        val cursor: Cursor = db.rawQuery(query, null)
        if(cursor!=null && cursor.count>0){
            cursor.moveToFirst()
            do{
                val idIndex = cursor.getColumnIndex(ID)
                val Question = cursor.getColumnIndex(Question)
                val OptionA = cursor.getColumnIndex(OptionA)
                val OptionB = cursor.getColumnIndex(OptionB)
                val OptionC = cursor.getColumnIndex(OptionC)
                val OptionD = cursor.getColumnIndex(OptionD)
                val id = cursor.getInt(idIndex)
                val question = cursor.getString(Question)
                val optionA = cursor.getString(OptionA)
                val optionB = cursor.getString(OptionB)
                val optionC = cursor.getString(OptionC)
                val optionD = cursor.getString(OptionD)
                val routainModel = RoutainModel(id, question, optionA, optionB, optionC, optionD)
                listRountain.add(routainModel)
            }
            while(cursor.moveToNext())


        }


        //curson is a class which will return row and column and also some other method
        return listRountain
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}