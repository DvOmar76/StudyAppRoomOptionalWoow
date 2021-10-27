package com.example.studyapproomoptional.Pages

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapproomoptional.R
import com.example.studyapproomoptional.Adapter.RVAdapter
import com.example.studyapproomoptional.DBRoom.Android.Android
import com.example.studyapproomoptional.DBRoom.Android.AndroidDatabase

class AndroidActivity : AppCompatActivity() {
    var firstTimeOpenAndroid=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)
        val dbRoom=AndroidDatabase.getInstance(applicationContext)
        val items = arrayListOf(
            arrayListOf("Project Setup", "Setting up an Android Studio Project.", "Detailed notes here."),
            arrayListOf("Console", "Printing to the console.", "Detailed notes here."),
            arrayListOf("Resource Files", "Identifying, editing, and using resource files.", "Detailed notes here."),
            arrayListOf("UI Elements", "Creating, modifying, and initializing UI Elements.", "Detailed notes here.")
        )
        loadData()
        // to enter this info one time
        if (!firstTimeOpenAndroid){
            for (i in 0..3){
                val title=items[i][0]
                val description=items[i][1]
                val details=items[i][2]
                val data=Android(0,title,description,details)
               dbRoom.androidDao().addNew(data)
            }
            firstTimeOpenAndroid=true
            saveData()
        }


        val list=dbRoom.androidDao().getAll()
        val rvAndroid = findViewById<RecyclerView>(R.id.rvAndroid)
        rvAndroid.adapter = RVAdapter(this,list,null )
        rvAndroid.layoutManager = LinearLayoutManager(this)
        title = "Android Review"
    }

    fun saveData(){
        val sharedPreferences = getSharedPreferences("firstTimeOpenAndroid", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.apply{
            putBoolean("firstTimeOpenAndroid",firstTimeOpenAndroid)
        }.apply()
    }



    fun loadData(){
        val sharedPreferences = getSharedPreferences("firstTimeOpenAndroid",Context.MODE_PRIVATE)
        firstTimeOpenAndroid=sharedPreferences.getBoolean("firstTimeOpenAndroid",false)

    }

}