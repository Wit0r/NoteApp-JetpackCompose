package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.noteapp.core.HomeConstants.ADD_NOTE
import com.example.noteapp.core.HomeConstants.DISMISS_TEXT
import com.example.noteapp.core.HomeConstants.PLACEHOLDER_CONTENT
import com.example.noteapp.core.HomeConstants.PLACEHOLDER_TITLE
import com.example.noteapp.core.HomeConstants.TITLE_NEW_NOTE
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.components.AlertDialogApp
import com.example.noteapp.presentation.components.TextFieldApp

@Composable
fun HomeAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addNote: (note: Note) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }

        AlertDialogApp(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(TITLE_NEW_NOTE))
            },
            text = {
                Column {
                    TextFieldApp(
                        value = title,
                        placeholder = { Text(text = stringResource(PLACEHOLDER_TITLE)) },
                        onTextValueChange = { newValue -> title = newValue },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextFieldApp(
                        value = content,
                        placeholder = { Text(text = stringResource(PLACEHOLDER_CONTENT)) },
                        onTextValueChange = { newValue -> content = newValue },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions {
                            closeDialog()
                            val note = Note(0, title, content)
                            addNote(note)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val note = Note(0, title, content)
                        addNote(note)
                    }
                ) {
                    Text(text = stringResource(ADD_NOTE))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(text = stringResource(DISMISS_TEXT))
                }
            }
        )

    }
}