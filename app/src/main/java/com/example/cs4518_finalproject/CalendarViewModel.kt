package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

private const val TAG = "CalendarViewModel"

class CalendarViewModel : ViewModel(){
    private val appRepository = AppRepository.get()

    fun getAssignmentsFromDate(date: String) = appRepository.getAssignmentsFromDate(date)

    init {
        Log.i(TAG, "CalendarViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "CalendarViewModel instance is about to be destroyed")
    }
}