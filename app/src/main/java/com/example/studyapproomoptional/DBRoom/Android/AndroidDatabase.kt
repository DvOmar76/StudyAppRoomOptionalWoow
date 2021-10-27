package com.example.studyapproomoptional.DBRoom.Android
import android.content.Context
import androidx.room.*
import androidx.room.Database

@Database(entities =[Android::class],version = 1,exportSchema = false)
abstract class AndroidDatabase :RoomDatabase()
{
    companion object
    {
        var instance:AndroidDatabase?=null
        fun getInstance(context: Context):AndroidDatabase
        {
            if (instance!=null)
            {
                return instance as AndroidDatabase
            }
            else
            {
                instance=Room.databaseBuilder(context,AndroidDatabase::class.java,"Android").run { allowMainThreadQueries() }.build()
                return instance as AndroidDatabase
            }
        }

    }
    abstract fun androidDao():AndroidDao

}