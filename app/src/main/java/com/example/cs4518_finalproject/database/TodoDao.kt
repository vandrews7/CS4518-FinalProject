package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cs4518_finalproject.ToDo
import java.util.*

@Dao
interface TodoDao {

    @Query("Select * from todo")
    fun getToDos(): LiveData<List<ToDo>>

    @Query("Select * from todo where id=(:id)")
    fun getToDo(id: UUID): LiveData<ToDo?>

    @Insert
    fun addTodo(todo: ToDo)

    @Update
    fun updateToDo(todo: ToDo)
}