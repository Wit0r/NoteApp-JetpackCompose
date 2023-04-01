package com.example.noteapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

    var expanded by mutableStateOf(false)
    var openDialog by mutableStateOf(false)

    var note by mutableStateOf(Note(0, "", ""))
        private set

    val notes = repository.getNotes()

    fun getNote(id: Int) = viewModelScope.launch { note = repository.getNote(id) }
    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
    fun deleteById(id: Int) = viewModelScope.launch { repository.deleteById(id) }
    fun updateTitle(title: String) {
        note = note.copy(title = title)
    }
    fun updateContent(content: String) {
        note = note.copy(content = content)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

}