package com.example.cs4518_finalproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cs4518_finalproject.*

@Database(entities = [Assignment::class, User::class, ToDo::class, SharedAssignment::class, Photo::class], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun assignmentDao(): AssignmentDao

    abstract fun userDao(): UserDao

    abstract fun sharedDao(): SharedDao

    abstract fun todoDao(): TodoDao

    abstract fun photoDao(): PhotoDao

}