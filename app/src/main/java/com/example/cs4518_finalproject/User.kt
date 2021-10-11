package com.example.cs4518_finalproject

import androidx.room.Entity

@Entity (primaryKeys = ["email" , "password"])
class User (var firstName: String = "",
            var lastName: String = "",
            var email: String = "",
            var password: String = ""){
}