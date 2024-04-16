package com.example.sqliteemployee

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun getEmployeeDao(): EmployeeDao
    companion object {
        private var INSTANCE: EmployeeDatabase? = null
        fun getInstance(context: Context): EmployeeDatabase {
            var instance = INSTANCE
            synchronized(this) {
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(
                            context, EmployeeDatabase::class.java,
                            "employee_db"
                        ).build()
                    INSTANCE = instance
                }
                return instance as EmployeeDatabase
            }
        }
    }
}

