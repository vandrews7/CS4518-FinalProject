package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cs4518_finalproject.Assignment
import java.util.*

@Dao
interface AssignmentDao {

    @Query("Select * from assignment")
    fun getAssignments(): LiveData<List<Assignment>>

    @Query("Select * from assignment where id=(:id)")
    fun getAssignment(id: UUID): LiveData<Assignment?>

    @Query("Select * from assignment where isCompleted=(1)") //idk if this is right
    fun getCompleted(): LiveData<List<Assignment>>

    @Query("Select isCompleted from assignment where id=(:id)")
    fun isCompleted(id: UUID): LiveData<Boolean>

    @Insert
    fun addAssignment(a: Assignment)

    @Update
    fun updateAssignment(a: Assignment)
}