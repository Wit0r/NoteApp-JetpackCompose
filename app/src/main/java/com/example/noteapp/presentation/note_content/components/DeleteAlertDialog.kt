package com.example.noteapp.presentation.note_content.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteViewModel

@Composable
fun DeleteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    viewModel: NoteViewModel = hiltViewModel(),
    noteId: Int
) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = "Do you really want to delete?"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        viewModel.deleteById(noteId)
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(text = "Cancel")
                }
            },
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            iconContentColor = MaterialTheme.colorScheme.onBackground,
            textContentColor = MaterialTheme.colorScheme.onBackground
        )
    }
}