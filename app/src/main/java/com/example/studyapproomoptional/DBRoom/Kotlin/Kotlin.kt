package com.example.studyapproomoptional.DBRoom.Kotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Kotlin")
data class Kotlin
    (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "title") val title:String?="default",
    @ColumnInfo(name = "description") val description:String?="default",
    @ColumnInfo(name = "details") val details:String?="default"
)

