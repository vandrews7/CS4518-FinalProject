package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ToDo (@PrimaryKey var id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var isCompleted: Boolean = false){
}