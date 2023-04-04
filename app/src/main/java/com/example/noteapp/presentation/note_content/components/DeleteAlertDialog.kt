package com.example.noteapp.presentation.note_content.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.CANCEL_TEXT
import com.example.noteapp.core.NoteConstants.DELETE_DIALOG_MESSAGE
import com.example.noteapp.core.NoteConstants.YES_TEXT
import com.example.noteapp.domain.model.NoteState
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.AlertDialogApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DeleteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    viewModel: NoteViewModel = hiltViewModel(),
    noteId: Int,
    navigateToHomeScreen: () -> Unit
) {
    if (openDialog) {

        val state by viewModel.state

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
            },
        )

        if (state.isDeleted) {
            closeDialog()
            navigateToHomeScreen()
        }

    }
}