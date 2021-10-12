package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "SharedViewModel"

class SharedViewModel : ViewModel(){

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()

    init {
        Log.i(TAG, "SharedViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "SharedViewModel instance is about to be destroyed")
    }
}