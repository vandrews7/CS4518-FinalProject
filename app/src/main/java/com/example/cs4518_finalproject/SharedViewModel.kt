package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "SharedViewModel"

class SharedViewModel : ViewModel(){
    init {
        Log.i(TAG, "SharedViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "SharedViewModel instance is about to be destroyed")
    }
}