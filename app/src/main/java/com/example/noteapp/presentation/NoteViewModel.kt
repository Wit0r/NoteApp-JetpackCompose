package com.example.noteapp.presentation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.core.NoteConstants.SNACK_NOTE_DELETED
import com.example.noteapp.core.NoteStateHolder
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.model.NoteState
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

    private val _noteState = NoteStateHolder._noteState
    val noteState = NoteStateHolder.noteState

    private val _snackBarHostState = mutableStateOf(SnackbarHostState())
    val snackBarHostState: MutableState<SnackbarHostState> = _snackBarHostState

    fun getNote(id: Int) = viewModelScope.launch { note = repository.getNote(id) }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

    fun deleteById(id: Int) = viewModelScope.launch {
        _noteState.value = NoteState(isLoading = true)
        try {
            repository.deleteNote(id)
            _noteState.value = NoteState(isDeleted = true)
            _snackBarHostState.value.showSnackbar(SNACK_NOTE_DELETED)
        } catch (e: Exception) {
            _noteState.value = NoteState(error = e.message)
        }
    }

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

    fun resetNoteState() {
        _noteState.value = NoteState(isDeleted = false, isLoading = false)
    }
}