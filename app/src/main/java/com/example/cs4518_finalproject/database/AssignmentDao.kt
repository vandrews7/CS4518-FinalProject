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
    fun addAssignment(a: Assignment) //TODO: do a thing here to insert an assignment into the db

    @Update
    fun updateTitle(a: Assignment, title: String) //TODO: do a thing here to update an existing assignment title

    @Update
    fun updateSubject(a: Assignment, subject: String) //TODO: do a thing here to update an existing assignment subject

    @Update
    fun updateDate(a: Assignment, dueDate: String) //TODO: do a thing here to update an existing assignment due date

    @Update
    fun updateStatus(a: Assignment, isCompleted: Boolean) //TODO: do a thing here to update an existing assignment status
}