package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

typealias Notes = List<Note>

interface NoteRepository {

    fun getNotes(): Flow<Notes>

    suspend fun getNote(id: Int): Note

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(id: Int)

}