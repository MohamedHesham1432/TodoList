package com.example.note_app.data.DB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("Select * from Note")
    suspend fun getAll(): List<Note>

    @Query("Select * from Note where isfavorite = 1")
    suspend fun getFavorites(): List<Note>

    @Query("Select * from Note where id = :id")
    suspend fun getNoteById(id: Int): Note

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}