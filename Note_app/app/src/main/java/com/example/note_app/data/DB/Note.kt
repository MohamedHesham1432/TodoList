package com.example.note_app.data.DB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val description: String,
    val title: String,
    val isfavorite: Boolean,
)
