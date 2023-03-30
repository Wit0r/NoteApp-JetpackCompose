package com.example.noteapp.presentation.home

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.MainViewModel
import com.example.noteapp.presentation.home.components.AddNoteAlertDialog
import com.example.noteapp.presentation.home.components.FloatingActionButtonApp
import com.example.noteapp.presentation.home.components.NotesContent
import com.example.noteapp.presentation.home.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navigateToUpdateNoteScreen: (noteId: Int) -> Unit
) {

    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { FloatingActionButtonApp(openDialog = { viewModel.openDialog() } ) },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            NotesContent(
                padding = paddingValues,
                notes = notes,
                deleteNote = { note -> viewModel.deleteNote(note) },
                navigateToUpdateNoteScreen = navigateToUpdateNoteScreen
            )
            AddNoteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialgo() },
                addNote = { task -> viewModel.addNote(task) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    )
}