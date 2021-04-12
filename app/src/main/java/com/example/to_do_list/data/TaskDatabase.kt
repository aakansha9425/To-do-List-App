package com.example.to_do_list.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import javax.inject.Inject

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    // this class is a database which will return the dao object for the class
    abstract fun taskDao(): TaskDao


    class Callback @Inject constructor() :RoomDatabase.Callback()
    {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
        }
    }
}