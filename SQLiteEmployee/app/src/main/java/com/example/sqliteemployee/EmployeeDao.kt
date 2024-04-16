package com.example.sqliteemployee

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert






@Dao
interface EmployeeDao {
    @Insert
    fun addEmp(emp:Employee) // emp:List <Employee>

    @Update
    fun updateEmp(emp:Employee)

    @Delete
    fun deleteEmp(emp:Employee)

    @Upsert
    fun upsertEmp (emp:Employee)//mettre a jour l'emp et si'il nexiste pas il l'insert

    @Query("select * from employee")
    fun getAllEmp ():List<Employee>

    @Query("select count(*) from employee")
    fun getNbEmp ():Int




}

