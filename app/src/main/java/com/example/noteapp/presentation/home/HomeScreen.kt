package com.example.noteapp.presentation.home

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.home.components.HomeAlertDialog
import com.example.noteapp.presentation.home.components.HomeContent
import com.example.noteapp.presentation.home.components.HomeFloatingButton
import com.example.noteapp.presentation.home.components.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    navigateToContentScreen: (noteId: Int) -> Unit
) {
    val notes by viewModel.notes.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = {
            HomeFloatingButton(
                openDialog = { viewModel.openDialog() },
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            HomeContent(
                padding = paddingValues,
                notes = notes,
                navigateToContentScreen = navigateToContentScreen
            )
            HomeAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialog() },
                addNote = { note -> viewModel.addNote(note) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    )
}