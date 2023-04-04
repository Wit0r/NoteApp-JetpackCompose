package com.example.noteapp.presentation.home

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.SNACK_NOTE_DELETED
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.home.components.HomeAlertDialog
import com.example.noteapp.presentation.home.components.HomeContent
import com.example.noteapp.presentation.home.components.HomeFloatingButton
import com.example.noteapp.presentation.home.components.HomeTopBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    navigateToContentScreen: (noteId: Int) -> Unit
) {
    val notes by viewModel.notes.collectAsState(initial = emptyList())
    val snackBarHostState by viewModel.snackBarHostState
    val noteState by viewModel.noteState.collectAsState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = {
            HomeFloatingButton(
                openDialog = { viewModel.openDialog() },
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
                snackbar = { data ->
                    Snackbar(
                        snackbarData = data,
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                }
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

    LaunchedEffect(noteState.isDeleted) {
        scope.launch {
            if (noteState.isDeleted) {
                snackBarHostState.showSnackbar(SNACK_NOTE_DELETED, duration = SnackbarDuration.Short)
            }
        }
    }

    LaunchedEffect(noteState.isDeleted) {
        scope.launch {
            if (noteState.isDeleted) {
                delay(10)
                viewModel.resetNoteState()
            }
        }
    }

}