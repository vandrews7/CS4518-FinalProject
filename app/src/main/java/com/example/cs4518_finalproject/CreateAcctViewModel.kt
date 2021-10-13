package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "CreateAcctViewModel"

class CreateAcctViewModel(): ViewModel(){

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()

    fun addUser(user: User) {
        Log.d(TAG, "user is being added to user table in database")
        appRepository.addUser(user)
    }

    init {
        Log.i(TAG, "CreateAcctViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "CreateAcctViewModel instance is about to be destroyed")
    }
}