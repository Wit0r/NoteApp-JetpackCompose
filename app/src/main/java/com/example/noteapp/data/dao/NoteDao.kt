package com.example.noteapp.data.dao

import androidx.room.*
import com.example.noteapp.core.Constants.TABLE_NAME
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id ASC")
    fun getNotes(): Flow<Notes>
    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getNote(id: Int): Note
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("DELETE FROM $TABLE_NAME WHERE id = :id")
    suspend fun deleteNoteById(id: Int)
}