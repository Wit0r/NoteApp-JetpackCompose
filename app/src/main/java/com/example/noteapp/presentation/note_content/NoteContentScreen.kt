package com.example.noteapp.presentation.note_content

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.note_content.components.DeleteAlertDialog
import com.example.noteapp.presentation.note_content.components.NoteContent
import com.example.noteapp.presentation.note_content.components.NoteContentTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteContentScreen(
    viewModel: NoteViewModel = hiltViewModel(),
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
                navigateBack = navigateBack
            )
        },
        content = { padding ->

            NoteContent(
                padding = padding,
                note = viewModel.note
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