package com.example.studyapproomoptional.DBRoom.Kotlin
import android.content.Context
import androidx.room.*
import com.example.studyapproomoptional.DBRoom.Android.AndroidDao

@Database(entities = [Kotlin::class],version = 1,exportSchema = false)
abstract class KotlinDatabase :RoomDatabase(){
    companion object
    {
        var instance:KotlinDatabase?=null
        fun getInstance(context: Context):KotlinDatabase
        {
            if (instance!=null)
            {
                return instance as KotlinDatabase
            }
            instance=Room.databaseBuilder(context,KotlinDatabase::class.java,"Kotlin").run { allowMainThreadQueries()}.build()
            return instance as KotlinDatabase
        }
    }
    abstract fun kotlinDao(): KotlinDao

}