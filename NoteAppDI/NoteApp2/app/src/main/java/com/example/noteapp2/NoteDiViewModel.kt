package com.example.noteapp2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp2.data.db.Note
import com.example.noteapp2.data.db.NoteDao
import com.example.noteapp2.data.db.NoteDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteDiViewModel @Inject constructor(private val noteDao: NoteDao) : ViewModel() {

    private val _allNotes = MutableStateFlow<List<Note>?>(null)
    val allNotes : StateFlow<List<Note>?> get() = _allNotes



    init {
        getAllNotes()
    }



    fun getAllNotes() {
        viewModelScope.launch {
            _allNotes.value = noteDao.getAll()
            println("All notes: ${_allNotes.value}")
        }
    }
    fun insertNote(note:Note){
        viewModelScope.launch {
            noteDao.insert(note)
            getAllNotes()
        }
    }

    fun updateNote(note:Note){
        viewModelScope.launch {
            noteDao.update(note)
            getAllNotes()

        }
    }

    fun getNoteById(id:Int){
        viewModelScope.launch {
            noteDao.getById(id)
            getAllNotes()
        }
    }

    fun deleteNote(note:Note){
        viewModelScope.launch {
            noteDao.deleteNote(note)
            getAllNotes()
        }
    }


}