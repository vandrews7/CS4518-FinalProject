package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

private const val TAG = "AssignmentListViewModel"

class AssignmentListViewModel: ViewModel(){
    private val appRepository = AppRepository.get()
    val assignmentListLiveData: LiveData<List<Assignment>> = appRepository.getAssignments()

    val assignments = mutableListOf<Assignment>()

    init{
        Log.i(TAG, "AssignmentListViewModel instance created")
        for (i in 0 until 100) {
            val assignment = Assignment()
            assignment.title = ""
            assignment.isCompleted = i % 2 == 0
            assignments += assignment
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "AssignmentListViewModel instance is about to be destroyed")
    }

}