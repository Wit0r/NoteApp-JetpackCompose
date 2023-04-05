package com.example.noteapp.presentation.note_content

import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    navigateToHomeScreen: () -> Unit,
    navigateToUpdateNote: (noteId: Int) -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getNote(noteId)
    }

    Scaffold(
        topBar = {
            NoteContentTopBar(
                navigateBack = navigateBack,
                navigateToUpdateNote = navigateToUpdateNote,
                note = viewModel.note
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