package com.example.noteapp.core

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import com.example.noteapp.domain.model.NoteState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

object NoteStateHolder {

    val _noteState = MutableStateFlow(NoteState())
    val noteState: StateFlow<NoteState> = _noteState

}