package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "AssignmentViewModel"

class AssignmentViewModel: ViewModel(){

    private val appRepository = AppRepository.get()

    init{
        Log.i(TAG, "AssignmentViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "AssignmentViewModel instance is about to be destroyed")
    }

}