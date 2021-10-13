package com.example.cs4518_finalproject

import java.util.*

data class Photo(val id: UUID = UUID.randomUUID()){
    val photoFileName
        get() = "IMG_$id.jpg"
}