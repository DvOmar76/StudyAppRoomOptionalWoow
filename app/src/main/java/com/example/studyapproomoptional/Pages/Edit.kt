package com.example.studyapproomoptional.Pages

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studyapproomoptional.DBRoom.Android.Android
import com.example.studyapproomoptional.DBRoom.Android.AndroidDatabase
import com.example.studyapproomoptional.DBRoom.Kotlin.Kotlin
import com.example.studyapproomoptional.DBRoom.Kotlin.KotlinDatabase
import com.example.studyapproomoptional.R
import kotlinx.android.synthetic.main.activity_edit.*


class Edit : AppCompatActivity() {
    lateinit var dbRoomAndroid: AndroidDatabase
    lateinit var dbRoomKotlin: KotlinDatabase
     var table=""
    lateinit var statusAn:Unit
    lateinit var statusKo:Unit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        btnAdd.setOnClickListener {
            checkButton()
            if (table.isNotEmpty())
            {
                val title = edTitleAdd.text.toString()
                val  description = edDescriptionADD.text.toString()
                val  details = edDetailsAdd.text.toString()

                if (title.isNotEmpty() && description.isNotEmpty() && details.isNotEmpty())
                {
                    if (this::dbRoomAndroid.isInitialized)
                    {
                        val data=Android(0,title,description,details)
                         statusAn =dbRoomAndroid.androidDao().addNew(data)
                    }
                    else
                    {
                        val data=Kotlin(0,title,description,details)
                        statusKo=dbRoomKotlin.kotlinDao().add(data)
                    }

                    if (this::statusKo.isInitialized||this::statusAn.isInitialized)
                    {
                        Toast.makeText(applicationContext, "data is added", Toast.LENGTH_SHORT).show()
                        edTitleAdd.text.clear()
                        edDescriptionADD.text.clear()
                        edDetailsAdd.text.clear()
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "error db", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(applicationContext, "please enter text", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "please select table", Toast.LENGTH_SHORT).show()

            }

        }
        btnDelete.setOnClickListener {
            checkButton()
            if (table.isNotEmpty())
            {
                try
                {
                    val id = edIDDelete.text.toString().toInt()
                    if (this::dbRoomAndroid.isInitialized)
                    {
                        val data=Android(id)
                        statusAn =dbRoomAndroid.androidDao().delete(data)
                    }
                    else
                    {
                        val data=Kotlin(id)
                        statusKo=dbRoomKotlin.kotlinDao().delete(data)
                    }

                    if (this::statusKo.isInitialized||this::statusAn.isInitialized)
                    {
                        Toast.makeText(applicationContext, "item is deleted", Toast.LENGTH_SHORT).show()
                        edIDDelete.text.clear()
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "id not found", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception)
                {
                    Toast.makeText(applicationContext, "please enter number in id", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "please select table", Toast.LENGTH_SHORT).show()

            }
        }

        btnUpdate.setOnClickListener {
            checkButton()

            if (table.isNotEmpty())
            {
                try {
                    val id = edIDUpdate.text.toString().toInt()
                    var title = edTitleUpdate.text.toString()
                    var description = edDescriptionUpdate.text.toString()
                    var details = edDetailsUpdate.text.toString()
                    if (title.isNotEmpty() && description.isNotEmpty() && details.isNotEmpty())
                    {
                        if (this::dbRoomAndroid.isInitialized)
                        {
                            val data=Android(id,title,description,details)
                            statusAn =dbRoomAndroid.androidDao().update(data)
                        }
                        else
                        {
                            val data=Kotlin(id,title,description,details)
                            statusKo=dbRoomKotlin.kotlinDao().update(data)
                        }
                        if (this::statusKo.isInitialized||this::statusAn.isInitialized)
                        {
                            Toast.makeText(applicationContext, "item is updated", Toast.LENGTH_SHORT).show()
                            edIDUpdate.text.clear()
                            edTitleUpdate.text.clear()
                            edDescriptionUpdate.text.clear()
                            edDetailsUpdate.text.clear()
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "id not found ", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "complete fields", Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception)
                {
                    Toast.makeText(
                        applicationContext,
                        "please enter number in id",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "please select table", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun checkButton(){
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            var rb:RadioButton=findViewById(checkedId)
            if (rb!=null)
            {
                if (rb==rbAndroid){
                    dbRoomAndroid=AndroidDatabase.getInstance(applicationContext)
                }
                else
                {
                    dbRoomKotlin= KotlinDatabase.getInstance(applicationContext)
                }
                table=rb.text.toString()
            }
        }
    }

}