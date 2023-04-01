package com.example.noteapp.presentation.note_content.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.Notes
import com.example.noteapp.presentation.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun DeleteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
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