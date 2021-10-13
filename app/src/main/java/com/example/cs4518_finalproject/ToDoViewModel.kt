package com.example.cs4518_finalproject

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "ToDoViewModel"

class ToDoViewModel : ViewModel(){

    private val appRepository = AppRepository.get()
    val todoListLiveData = appRepository.getToDos()

    fun addToDo(toDo: ToDo) = appRepository.addToDo(toDo)

    init {
        Log.i(TAG, "ToDoViewModel instance created")
    }

    override fun onCleared(){
        super.onCleared()
        Log.i(TAG, "ToDoViewModel instance is about to be destroyed")
    }
}