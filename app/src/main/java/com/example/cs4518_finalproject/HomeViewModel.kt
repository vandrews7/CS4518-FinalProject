package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "HomeViewModel"

class HomeViewModel(): ViewModel() {

    private val appRepository = AppRepository.get()
    private val userListLiveData = appRepository.getUsers()
    private val assignmentListLiveData = appRepository.getAssignments()
    private val sharedListLiveData = appRepository.getAllShared()
    private val todoListLiveData = appRepository.getToDos()

    init {
        Log.i(TAG, "HomeViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "HomeViewModel instance is about to be destroyed")
    }
}
