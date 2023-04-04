package com.example.noteapp.domain.model

data class NoteState(
    val isLoading: Boolean = false,
    var isDeleted: Boolean = false,
    val error: String? = null
)
