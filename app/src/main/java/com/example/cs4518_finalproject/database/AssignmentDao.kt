package com.example.cs4518_finalproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.cs4518_finalproject.Assignment

@Dao
interface AssignmentDao {
    @Insert
    fun addAssignment(a: Assignment) //TODO: do a thing here to insert an assignment into the db

    @Update
    fun updateAssignment(a: Assignment) //TODO: do a thing here to update an existing assignment
}