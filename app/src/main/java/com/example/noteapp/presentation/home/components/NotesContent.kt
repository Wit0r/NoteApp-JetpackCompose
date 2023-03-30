package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.Notes

@Composable
fun NotesContent(
    padding: PaddingValues,
    notes: Notes,
    deleteNote: (note: Note) -> Unit,
    navigateToUpdateNoteScreen: (noteId: Int) -> Unit
) {
    val context = LocalContext.current

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        columns = GridCells.Adaptive(minSize = 164.dp),
        verticalArrangement = Arrangement.Top,
        horizontalArrangement = Arrangement.Start
    ) {

        items(notes) { note ->
            TaskCard(
                note = note,
                deleteNote = { deleteNote(note) },
                navigateToUpdateNoteScreen = navigateToUpdateNoteScreen
            )
        }
    }
}