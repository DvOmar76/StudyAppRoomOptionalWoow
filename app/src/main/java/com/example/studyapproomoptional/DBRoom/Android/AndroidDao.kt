package com.example.studyapproomoptional.DBRoom.Android
import androidx.room.*
@Dao
interface AndroidDao {
    @Query("select * from android order by id asc")
    fun getAll():List<Android>
    @Insert
    fun addNew(android: Android)
    @Update
    fun update(android: Android)
    @Delete
    fun delete(android: Android)
}