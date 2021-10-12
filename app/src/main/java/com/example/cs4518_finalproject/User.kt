package com.example.cs4518_finalproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (var firstName: String = "",
            var lastName: String = "",
            @PrimaryKey var email: String = "",
            var password: String = ""){
}