package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "CreateAcctViewModel"

class CreateAcctViewModel(): ViewModel(){
    init {
        Log.i(TAG, "CreateAcctViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "CreateAcctViewModel instance is about to be destroyed")
    }
}