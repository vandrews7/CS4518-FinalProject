package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "LoginViewModel"

class LoginViewModel(): ViewModel(){

    private val appRepository = AppRepository.get()
    private val userListLiveData = appRepository.getUsers()
    private val assignmentListLiveData = appRepository.getAssignments()

    init {
        Log.i(TAG, "LoginViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "LoginViewModel instance is about to be destroyed")
    }
}