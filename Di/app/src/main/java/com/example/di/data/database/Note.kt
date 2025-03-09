package com.example.di.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val uid: Int=0,
    val title: String?,
    val desctiption: String?,
    val isfavorite: Boolean
)

