package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "LoginViewModel"

class LoginViewModel(): ViewModel(){

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()

    fun login(email: String, password: String) = appRepository.login(email, password)

    init {
        Log.i(TAG, "LoginViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "LoginViewModel instance is about to be destroyed")
    }
}