package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "HomeViewModel"

class HomeViewModel(): ViewModel() {

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()

    init {
        Log.i(TAG, "HomeViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "HomeViewModel instance is about to be destroyed")
    }
}
