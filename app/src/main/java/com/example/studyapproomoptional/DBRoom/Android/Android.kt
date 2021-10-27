package com.example.studyapproomoptional.DBRoom.Android
import androidx.room.*
@Entity(tableName = "Android")
data class Android
    (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "title") val title:String?="default",
    @ColumnInfo(name = "description") val description:String?="default",
    @ColumnInfo(name = "details") val details:String?="default"
)
