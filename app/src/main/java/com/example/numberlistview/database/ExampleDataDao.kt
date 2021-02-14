package com.example.numberlistview.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.numberlistview.data.ExampleData

@Dao
interface ExampleDataDao {
    @Query("SELECT * FROM data")
    fun getAll(): LiveData<List<ExampleData>>

    @Insert
    fun insert(data: ExampleData)

    @Update
    fun update(data: ExampleData)

    @Delete
    fun delete(data: ExampleData)
}