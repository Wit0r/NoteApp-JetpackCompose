package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.core.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String
)