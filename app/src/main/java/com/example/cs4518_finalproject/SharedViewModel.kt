package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "SharedViewModel"

class SharedViewModel : ViewModel(){

    private val appRepository = AppRepository.get()
    private val userListLiveData = appRepository.getUsers()
    private val assignmentListLiveData = appRepository.getAssignments()
    private val sharedListLiveData = appRepository.getAllShared()
    private val todoListLiveData = appRepository.getToDos()

    init {
        Log.i(TAG, "SharedViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "SharedViewModel instance is about to be destroyed")
    }
}