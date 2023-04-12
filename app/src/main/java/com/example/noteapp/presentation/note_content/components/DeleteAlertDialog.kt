package com.example.noteapp.presentation.note_content.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.CANCEL_TEXT
import com.example.noteapp.core.NoteConstants.DELETE_DIALOG_MESSAGE
import com.example.noteapp.core.NoteConstants.YES_TEXT
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.AlertDialogApp

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
                    text = stringResource(DELETE_DIALOG_MESSAGE)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.deleteById(noteId)
                    }
                ) {
                    Text(text = stringResource(YES_TEXT))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(text = stringResource(CANCEL_TEXT))
                }
            }
        )

        LaunchedEffect(noteState.isDeleted) {
            if (noteState.isDeleted) {
                closeDialog()
                navigateToHomeScreen()
            }
        }

    }
}