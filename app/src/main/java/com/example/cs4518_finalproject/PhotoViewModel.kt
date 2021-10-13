package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel
import java.io.File

private const val TAG = "PhotoViewModel"


class PhotoViewModel() : ViewModel(){

    private val appRepository = AppRepository.get()
    val userListLiveData = appRepository.getUsers()
    val assignmentListLiveData = appRepository.getAssignments()
    val sharedListLiveData = appRepository.getAllShared()
    val todoListLiveData = appRepository.getToDos()
    val photoLiveData = appRepository.getPhotos()

    init {
        Log.i(TAG, "PhotoViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "PhotoViewModel instance is about to be destroyed")
    }

    fun getPhotoFile(photo: Photo): File {
        return appRepository.getPhotoFile(photo)
    }
}