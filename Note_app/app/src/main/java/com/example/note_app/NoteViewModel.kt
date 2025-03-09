package com.example.note_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app.data.DB.Note
import com.example.note_app.data.DB.NoteDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val noteDao = NoteDatabase.getDatabase(application).noteDao()


    private val _Getnote= MutableStateFlow<List<Note>?>(null)
    val Getnote: StateFlow<List<Note>?> get() = _Getnote

    fun getAllNotes() {
        viewModelScope.launch {
            _Getnote.value = noteDao.getAll()
        }

    }

}