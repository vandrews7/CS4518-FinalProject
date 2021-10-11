package com.example.cs4518_finalproject

import java.util.*

class User (val id: UUID = UUID.randomUUID(),
            var firstName: String = "",
            var lastName: String = "",
            var email: String = "",
            var birthday: String = "",
            var password: String = ""){
}