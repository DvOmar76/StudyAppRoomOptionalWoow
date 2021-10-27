package com.example.studyapproomoptional.DBRoom.Kotlin
import androidx.room.*
@Dao
interface KotlinDao {
    @Query("select * from kotlin order by id asc")
    fun getAll():List<Kotlin>
    @Insert
    fun add(kotlin: Kotlin)
    @Update
    fun update(kotlin: Kotlin)
    @Delete
    fun delete(kotlin: Kotlin)
}