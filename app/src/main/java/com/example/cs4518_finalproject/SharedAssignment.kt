package com.example.cs4518_finalproject

import java.util.*

data class SharedAssignment( val id: UUID = UUID.randomUUID(),
                             var title: String = "",
                             var subject: String = "",
                             var dueDate: String = "",
                             var isCompleted: Boolean = false) {
}