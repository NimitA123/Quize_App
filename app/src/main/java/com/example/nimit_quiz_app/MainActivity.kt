package com.example.nimit_quiz_app



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var routineList: MutableList<RoutainModel> = mutableListOf()
    lateinit var mAdapter: RoutineAdapter
    lateinit var dbhandler: DatabaseHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dbhandler = DatabaseHandler(this)
        routineList = dbhandler.Nimit()
        mAdapter = RoutineAdapter(this, routineList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter

        floatingActionButton.setOnClickListener {
            dbhandler.insertRoutine("Who is the Prime Minister of India", "Narendra Modi",
                "Arvindra Kejariwal", "Rahul Gandhi", "Akhilesh Yadav")
            dbhandler.insertRoutine("What is the capital of India", "Delhi",
                "Indore", "Banglore", "Mumbai")

            dbhandler.insertRoutine("Who won the last IPL", "Chennai",
                "Banglore", "Kolkata", "Delhi")

            dbhandler.insertRoutine("what is the Capital of M.P.", "Bhopal",
                "Indore", "Sagar", "Jabalpur")

            dbhandler.insertRoutine("Who is the chief Minister of U.P.", "Yogi",
                "Rahul Gandhi", "Akhilesh yadav", "Mayabati ")


        }



    }



}