package com.example.numberlistview.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.numberlistview.data.ExampleData
import com.example.numberlistview.database.ExampleDataRepository
import com.example.numberlistview.database.ExampleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ExampleDataRepository
    var exampleDataList: LiveData<List<ExampleData>>

    init {
        val exampleDataDao = ExampleDatabase.getInstance(application).exampleDataDao()
        repository = ExampleDataRepository(exampleDataDao)
        exampleDataList = repository.getAll()
    }

    fun insert(data: ExampleData) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(data)
    }

    fun update(data: ExampleData) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(data)
    }

    fun delete(data: ExampleData) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(data)
    }
}