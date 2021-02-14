package com.example.numberlistview.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.numberlistview.data.ExampleData

class ExampleDataRepository(private val exampleDataDao: ExampleDataDao) {
    @WorkerThread
    fun getAll(): LiveData<List<ExampleData>> {
        return exampleDataDao.getAll()
    }

    @WorkerThread
    fun insert(data: ExampleData) {
        exampleDataDao.insert(data)
    }

    @WorkerThread
    fun update(data: ExampleData) {
        exampleDataDao.update(data)
    }

    fun delete(data: ExampleData) {
        exampleDataDao.delete(data)
    }
}