package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cs4518_finalproject.SharedAssignment
import java.util.*

@Dao
interface SharedDao {
    @Query("Select * from shared")
    fun getAllShared(): LiveData<List<SharedAssignment>>

    @Query("Select * from shared where id=(:id)")
    fun getShared(id: UUID): LiveData<SharedAssignment?>

    @Insert
    fun addShared(shared: SharedAssignment)

    @Update
    fun updateShared(shared: SharedAssignment)
}