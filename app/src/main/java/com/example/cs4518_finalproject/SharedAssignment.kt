package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "shared")
data class SharedAssignment(@PrimaryKey var id: UUID = UUID.randomUUID(),
                            var title: String = "",
                            var subject: String = "",
                            var dueDate: String = "",
                            var isCompleted: Boolean = false) {
}