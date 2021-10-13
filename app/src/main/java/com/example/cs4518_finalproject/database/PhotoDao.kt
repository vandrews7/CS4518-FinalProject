package com.example.cs4518_finalproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cs4518_finalproject.Photo
import java.util.*

@Dao
interface PhotoDao {
    @Query("Select * from photo")
    fun getPhotos(): LiveData<Photo>

    @Query("Select * from photo where id=(:id)")
    fun getPhoto(id: UUID): LiveData<Photo?>

    @Insert
    fun addPhoto(photo: Photo)
}