package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.core.Constants.TABLE_NAME
import com.example.noteapp.data.dao.NoteDao
import com.example.noteapp.data.network.NoteDb
import com.example.noteapp.data.repository.NoteRepositoryImpl
import com.example.noteapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideNoteDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context, NoteDb::class.java, TABLE_NAME).build()

    @Provides
    fun providesNoteDao(noteDb: NoteDb) = noteDb.noteDao

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)

}