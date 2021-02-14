package com.example.numberlistview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class ExampleData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val dataId: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "list") val numberList: List<Int>
)