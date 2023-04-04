package com.example.noteapp.presentation.note_content.components

import android.widget.Toast
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.CANCEL_TEXT
import com.example.noteapp.core.NoteConstants.DELETE_DIALOG_MESSAGE
import com.example.noteapp.core.NoteConstants.TOAST_NOTE_DELETED
import com.example.noteapp.core.NoteConstants.YES_TEXT
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.AlertDialogApp
import kotlinx.coroutines.delay

@Composable
fun DeleteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    viewModel: NoteViewModel = hiltViewModel(),
    noteId: Int,
    navigateToHomeScreen: () -> Unit
) {
    if (openDialog) {

        val noteState by viewModel.noteState.collectAsState()

        AlertDialogApp(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = DELETE_DIALOG_MESSAGE
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
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
            }
        )

        if (noteState.isDeleted) {
            closeDialog()
            navigateToHomeScreen()
        }

    }
}