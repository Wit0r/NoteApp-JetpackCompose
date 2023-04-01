package com.example.noteapp.presentation.note_content.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.CANCEL_TEXT
import com.example.noteapp.core.NoteConstants.DELETE_DIALOG_MESSAGE
import com.example.noteapp.core.NoteConstants.YES_TEXT
import com.example.noteapp.presentation.NoteViewModel

@Composable
fun DeleteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    viewModel: NoteViewModel = hiltViewModel(),
    noteId: Int
) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = DELETE_DIALOG_MESSAGE
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        viewModel.deleteById(noteId)
                    }
                ) {
                    Text(text = YES_TEXT)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(text = CANCEL_TEXT)
                }
            },
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            iconContentColor = MaterialTheme.colorScheme.onBackground,
            textContentColor = MaterialTheme.colorScheme.onBackground
        )
    }
}