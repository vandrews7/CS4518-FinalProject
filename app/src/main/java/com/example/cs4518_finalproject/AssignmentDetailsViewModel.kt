package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "AsgnDetailsViewModel"

class AssignmentDetailsViewModel : ViewModel(){

    private val appRepository = AppRepository.get()

    fun addAssignment(asgn: Assignment) = appRepository.addAssignment(asgn)

    init {
        Log.i(TAG, "AsgnDetailsViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "AsgnDetailsViewModel instance is about to be destroyed")
    }
}