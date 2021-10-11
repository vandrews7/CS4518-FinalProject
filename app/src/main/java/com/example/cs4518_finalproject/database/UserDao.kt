package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cs4518_finalproject.User

@Dao
interface UserDao {
    @Query("Select * from user where (email=(:email) AND password=(:password))")
    fun login(email: String, password: String): List<User?> //maybe this is right i have no idea we will have to mess with it

    @Query("Select * from user where email=(:email)") //this will be to share an assignment with another user, you just have to have their email
    fun getUser(email: String): LiveData<List<User>>

    @Query("Select firstName from user where email=(:email)")
    fun getUsername(email: String): String

    @Insert
    fun addUser(user: User) //TODO: figure out how to add a user to the db user table

    @Update
    fun updatePassword(user:User, newPassword: String) //TODO: figure out how to update a password in the user db table
}