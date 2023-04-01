package com.example.noteapp.presentation.note_content

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.MainViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.noteapp.presentation.note_content.components.DeleteAlertDialog
import com.example.noteapp.presentation.note_content.components.NoteContent
import com.example.noteapp.presentation.note_content.components.NoteContentTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteContentScreen(
    viewModel: MainViewModel = hiltViewModel(),
    noteId: Int,
    navigateBack: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getNote(noteId)
    }

    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            NoteContentTopBar(
                navigateBack = navigateBack,
                openDialog = viewModel.openDialog
            )
        },
        content = { padding ->
            NoteContent(
                padding = padding,
                note = viewModel.note,
                updateTitle = { title -> viewModel.updateTitle(title) },
                updateContent = { content ->  viewModel.updateContent(content) },
                updateNote = { note -> viewModel.updateNote(note) },
                navigateBack = navigateBack
            )
            DeleteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialog() },
                noteId = noteId,
                navigateToHomeScreen = navigateToHomeScreen
            )
        },
        contentColor = MaterialTheme.colorScheme.onBackground,
        containerColor = MaterialTheme.colorScheme.background
    )

}