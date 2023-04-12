@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.noteapp.presentation.update_note

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.update_note.components.UpdateNoteContent
import com.example.noteapp.presentation.update_note.components.UpdateNoteTopBar

@Composable
fun UpdateNoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    noteId: Int,
    navigateBack: () -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getNote(noteId)
    }

    Scaffold(
        topBar = {
            UpdateNoteTopBar(
                note = viewModel.note,
                navigateBack = navigateBack,
                updateTitle = { title -> viewModel.updateTitle(title)}
            )
        },
        content = { padding ->
            UpdateNoteContent(
                padding = padding,
                note = viewModel.note,
                updateContent = { content -> viewModel.updateContent(content) },
                updateNote = { note -> viewModel.updateNote(note) },
                navigateBack = navigateBack
            )
        },
        contentColor = MaterialTheme.colorScheme.onBackground,
        containerColor = MaterialTheme.colorScheme.background
    )

}