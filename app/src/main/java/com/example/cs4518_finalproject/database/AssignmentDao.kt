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

    @Insert
    fun addAssignment(a: Assignment)

    @Update
    fun updateAssignment(a: Assignment)
}