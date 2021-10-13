package com.example.cs4518_finalproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.cs4518_finalproject.database.MainDatabase
import java.io.File
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "main-database"

class AppRepository private constructor(context: Context) {

    private val database : MainDatabase = Room.databaseBuilder(
        context.applicationContext,
        MainDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val executor = Executors.newSingleThreadExecutor()
    private val userDao = database.userDao()
    private val filesDir = context.applicationContext.filesDir

    fun getUsers() = userDao.getUsers()
    fun checkLogin(email: String, password: String): LiveData<User?> = userDao.checkLogin(email, password)
    fun addUser(user: User) {
        executor.execute {
            userDao.addUser(user)
        }
    }

    private val assignmentDao = database.assignmentDao()

    fun getAssignments(): LiveData<List<Assignment>> = assignmentDao.getAssignments()
    fun getAssignmentsFromDate(date: String): LiveData<List<Assignment>> = assignmentDao.getAssignmentsFromDate(date)
    fun isCompleted(id: UUID): LiveData<Boolean> = assignmentDao.isCompleted(id)
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

    private val sharedDao = database.sharedDao()

    fun getAllShared(): LiveData<List<SharedAssignment>> = sharedDao.getAllShared()
    fun getShared(id: UUID): LiveData<SharedAssignment?> = sharedDao.getShared(id)
    fun addShared(shared: SharedAssignment) {
        executor.execute {
            sharedDao.addShared(shared)
        }
    }
    fun updatedShared(shared: SharedAssignment) {
        executor.execute {
            sharedDao.updateShared(shared)
        }
    }

    private val todoDao = database.todoDao()

    fun getToDos(): LiveData<List<ToDo>> = todoDao.getToDos()
    fun getToDo(id: UUID): LiveData<ToDo?> = todoDao.getToDo(id)
    fun addToDo(todo: ToDo) {
        executor.execute {
            todoDao.addTodo(todo)
        }
    }
    fun updateToDo(todo: ToDo) {
        executor.execute {
            todoDao.updateToDo(todo)
        }
    }

    private val photoDao = database.photoDao()

    fun getPhotos(): LiveData<Photo> = photoDao.getPhotos()
    fun getPhoto(id: UUID): LiveData<Photo?> = photoDao.getPhoto(id)
    fun addPhoto(photo: Photo) {
        executor.execute {
            photoDao.addPhoto(photo)
        }
    }
    fun getPhotoFile(photo: Photo): File = File(filesDir, photo.photoFileName)

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