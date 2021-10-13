package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Photo(@PrimaryKey val id: UUID = UUID.randomUUID()){
    val photoFileName
        get() = "IMG_$id.jpg"
}