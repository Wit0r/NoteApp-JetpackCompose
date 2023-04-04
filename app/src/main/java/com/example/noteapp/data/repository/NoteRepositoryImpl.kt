package com.example.noteapp.data.repository

import com.example.noteapp.data.dao.NoteDao
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun getNotes() = noteDao.getNotes()
    override suspend fun getNote(id: Int) = noteDao.getNote(id)
    override suspend fun addNote(note: Note) = noteDao.addNote(note)
    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    override suspend fun deleteById(id: Int) = noteDao.deleteById(id)

}