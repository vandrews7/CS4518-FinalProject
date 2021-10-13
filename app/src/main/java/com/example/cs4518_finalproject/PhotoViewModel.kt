package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "PhotoViewModel"

class PhotoViewModel : ViewModel(){
    init {
        Log.i(TAG, "PhotoViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "PhotoViewModel instance is about to be destroyed")
    }

//    fun savePhoto(photo:Photo){
//        AppRepository.update
//    }
//
//    fun getPhotoFile(photo: Photo): File {
//        return AppRepository.getP
//    } //TODO finish this, pg. 591
}