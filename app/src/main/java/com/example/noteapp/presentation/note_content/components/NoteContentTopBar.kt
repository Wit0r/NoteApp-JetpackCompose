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
                    contentDescription = "Back to home screen"
                )
            }
        },
        actions = {
            IconButton(onClick = {  } ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit Note"
                )
            }

            IconButton(onClick = { viewModel.openDialog() } ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Delete Note"
                )
            }
        },
        title = {

        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)