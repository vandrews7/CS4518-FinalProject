package com.example.cs4518_finalproject

import android.app.Application

class WYDApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        AppRepository.initialize(this)
    }
}