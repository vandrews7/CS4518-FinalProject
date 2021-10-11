package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Assignment(@PrimaryKey val id: UUID = UUID.randomUUID(),
var title: String = "",
var subject: String = "",
var dueDate: String = ""){

}