package com.example.cs4518_finalproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.cs4518_finalproject.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User) //TODO: figure out how to add a user to the db user table

    @Update
    fun updatePassword(user:User, newPassword: String) //TODO: figure out how to update a password in the user db table
}