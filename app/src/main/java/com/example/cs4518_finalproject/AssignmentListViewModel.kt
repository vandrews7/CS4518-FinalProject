package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "AssignmentViewModel"

class AssignmentViewModel: ViewModel(){

    private val appRepository = AppRepository.get()
    private val userListLiveData = appRepository.getUsers()
    private val assignmentListLiveData = appRepository.getAssignments()
    private val sharedListLiveData = appRepository.getAllShared()
    private val todoListLiveData = appRepository.getToDos()

    val assignments = mutableListOf<Assignment>()

    init{
        Log.i(TAG, "AssignmentViewModel instance created")
        for (i in 0 until 100) {
            val assignment = Assignment()
            assignment.title = "" //TODO
            assignment.isCompleted = i % 2 == 0
            assignments += assignment
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "AssignmentViewModel instance is about to be destroyed")
    }

}