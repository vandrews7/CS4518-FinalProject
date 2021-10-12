package com.example.cs4518_finalproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.cs4518_finalproject.database.MainDatabase
import java.lang.IllegalStateException
import java.util.*

private const val DATABASE_NAME = "main-database"

class AppRepository private constructor(context: Context) {

    private val database : MainDatabase = Room.databaseBuilder(
        context.applicationContext,
        MainDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val userDao = database.userDao()

    fun getUsers() = userDao.getUsers()
    fun login(email: String, password: String): LiveData<User?> = userDao.login(email, password)
    fun getUser(email: String): LiveData<User?> = userDao.getUser(email)
    fun getUsername(email: String): String? = userDao.getUsername(email)
    fun addUser(user: User) = userDao.addUser(user)
    fun updatePassword(user: User, password: String) = userDao.updatePassword(user, password)

    private val assignmentDao = database.assignmentDao()

    fun getAssignments() = assignmentDao.getAssignments()
    fun getAssignment(id: UUID) = assignmentDao.getAssignment(id)
    fun addAssignment(a: Assignment) = assignmentDao.addAssignment(a)
    fun updateTitle(a: Assignment, title: String) = assignmentDao.updateTitle(a, title)
    fun updateSubject(a: Assignment, subject: String) = assignmentDao.updateSubject(a, subject)
    fun updateDate(a: Assignment, dueDate: String) = assignmentDao.updateDate(a, dueDate)
    fun updateStatus(a: Assignment, isCompleted: Boolean) = assignmentDao.updateStatus(a, isCompleted)

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