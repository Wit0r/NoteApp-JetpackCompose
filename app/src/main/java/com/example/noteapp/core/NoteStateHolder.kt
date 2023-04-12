package com.example.noteapp.core

import com.example.noteapp.domain.model.NoteState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NoteStateHolder {

    val _noteState = MutableStateFlow(NoteState())
    val noteState: StateFlow<NoteState> = _noteState

}