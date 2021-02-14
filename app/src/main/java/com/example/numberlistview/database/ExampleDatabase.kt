package com.example.numberlistview.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.numberlistview.data.ExampleData
import com.example.numberlistview.data.ListToJSONConverter

@Database(entities = [ExampleData::class], version = 1)
@TypeConverters(ListToJSONConverter::class)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDataDao(): ExampleDataDao

    companion object {
        @Volatile
        private var INSTANCE: ExampleDatabase? = null

        fun getInstance(context: Context): ExampleDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExampleDatabase::class.java,
                    "examples"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}