package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "CalendarViewModel"

class CalendarViewModel : ViewModel(){
    init {
        Log.i(TAG, "CalendarViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "CalendarViewModel instance is about to be destroyed")
    }
}