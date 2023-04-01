package com.example.noteapp.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.data.dao.NoteDao
import com.example.noteapp.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = true
)
abstract class NoteDb: RoomDatabase() {
    abstract val noteDao: NoteDao
}