package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "ToDoDetailsViewModel"

class ToDoDetailsViewModel : ViewModel(){
    init {
        Log.i(TAG, "ToDoDetailsViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "ToDoDetailsViewModel instance is about to be destroyed")
    }
}