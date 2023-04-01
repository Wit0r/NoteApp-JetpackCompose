package com.example.noteapp.presentation.note_content.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.R
import com.example.noteapp.core.NoteConstants.BACK_BUTTON_CD
import com.example.noteapp.core.NoteConstants.DELETE_NOTE_CD
import com.example.noteapp.core.NoteConstants.EDIT_NOTE_CD
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.TopBarApp

@Composable
fun NoteContentTopBar(
    navigateBack: () -> Unit,
    viewModel: NoteViewModel = hiltViewModel()
) {
    TopBarApp(
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    arrow_back_icon,
                    contentDescription = BACK_BUTTON_CD
                )
            }
        },
        actions = {
            IconButton(onClick = {  } ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = EDIT_NOTE_CD
                )
            }

            IconButton(onClick = { viewModel.openDialog() } ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = DELETE_NOTE_CD
                )
            }
        },
        title = {

        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)