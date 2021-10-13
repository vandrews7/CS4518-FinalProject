package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cs4518_finalproject.User

@Dao
interface UserDao {

    @Query("Select * from user")
    fun getUsers(): LiveData<List<User>>

    @Query("Select * from user where (email=(:email) AND password=(:password))") //this will be null if the user and password combo doesn't exist so
    fun checkLogin(email: String, password: String): LiveData<User?> //in theory this is right

    @Query("Select * from user where email=(:email)") //this will be to share an assignment with another user, you just have to have their email
    fun getUser(email: String): LiveData<User?>

    @Query("Select firstName from user where email=(:email)")
    fun getUsername(email: String): LiveData<String?>

    @Insert
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)
}