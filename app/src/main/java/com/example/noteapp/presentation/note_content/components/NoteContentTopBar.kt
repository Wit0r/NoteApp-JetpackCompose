package com.example.noteapp.presentation.note_content.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.R
import com.example.noteapp.core.NoteConstants.BACK_BUTTON_CD
import com.example.noteapp.core.NoteConstants.DELETE_NOTE_CD
import com.example.noteapp.core.NoteConstants.EDIT_NOTE_CD
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.TopBarApp
import com.example.noteapp.presentation.components.TopBarStyle

@Composable
fun NoteContentTopBar(
    viewModel: NoteViewModel = hiltViewModel(),
    note: Note,
    navigateBack: () -> Unit,
    navigateToUpdateNote: (noteId: Int) -> Unit

) {
    TopBarApp(
        topBarStyle = TopBarStyle.CENTER,
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    arrow_back_icon,
                    contentDescription = stringResource(BACK_BUTTON_CD)
                )
            }
        },
        actions = {
            IconButton(onClick = { navigateToUpdateNote(note.id) } ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = stringResource(EDIT_NOTE_CD)
                )
            }

            IconButton(onClick = { viewModel.openDialog() } ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = stringResource(DELETE_NOTE_CD)
                )
            }
        },
        title = {

        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)