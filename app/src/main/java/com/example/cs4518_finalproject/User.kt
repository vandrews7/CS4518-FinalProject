package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class User (@PrimaryKey var id: UUID = UUID.randomUUID(),
            var firstName: String = "",
            var lastName: String = "",
            var email: String = "",
            var birthday: String = "",
            var password: String = ""){
}