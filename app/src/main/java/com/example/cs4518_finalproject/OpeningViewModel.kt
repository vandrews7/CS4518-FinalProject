package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "OpeningViewModel"

class OpeningViewModel : ViewModel(){

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()

    init {
        Log.i(TAG, "OpeningViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "OpeningViewModel instance is about to be destroyed")
    }
}