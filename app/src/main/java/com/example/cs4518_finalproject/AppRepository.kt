package com.example.cs4518_finalproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.cs4518_finalproject.database.MainDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "main-database"

class AppRepository private constructor(context: Context) {

    //TODO: add appRepository to AssignmentDetailViewModel and override onStop() function to save updated assignment info (listing 12.16)

    private val database : MainDatabase = Room.databaseBuilder(
        context.applicationContext,
        MainDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val executor = Executors.newSingleThreadExecutor()
    private val userDao = database.userDao()

    fun getUsers() = userDao.getUsers()
    fun login(email: String, password: String): LiveData<User?> = userDao.login(email, password)
    fun getUser(email: String): LiveData<User?> = userDao.getUser(email)
    fun getUsername(email: String): String? = userDao.getUsername(email)
    fun addUser(user: User) {
        executor.execute {
            userDao.addUser(user)
        }
    }
    fun updateUser(user: User) {
        executor.execute {
            userDao.updateUser(user)
        }
    }

    private val assignmentDao = database.assignmentDao()

    fun getAssignments() = assignmentDao.getAssignments()
    fun getAssignment(id: UUID) = assignmentDao.getAssignment(id)
    fun addAssignment(a: Assignment) {
        executor.execute {
            assignmentDao.addAssignment(a)
        }
    }
    fun updateAssignment(a: Assignment) {
        executor.execute {
            assignmentDao.updateAssignment(a)
        }
    }

    companion object {
        private var INSTANCE: AppRepository? = null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = AppRepository(context)
            }
        }

        fun get(): AppRepository {
            return INSTANCE ?:
            throw IllegalStateException("AppRepository must be initialized")
        }
    }
}