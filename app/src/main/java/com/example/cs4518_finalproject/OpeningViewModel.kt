package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "OpeningViewModel"

class OpeningViewModel : ViewModel(){
    init {
        Log.i(TAG, "OpeningViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "OpeningViewModel instance is about to be destroyed")
    }
}