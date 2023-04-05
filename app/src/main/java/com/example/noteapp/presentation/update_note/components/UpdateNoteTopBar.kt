package com.example.noteapp.presentation.update_note.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.R
import com.example.noteapp.core.NoteConstants
import com.example.noteapp.core.NoteConstants.BACK_BUTTON_CD
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.TextFieldApp
import com.example.noteapp.presentation.components.TopBarApp

@Composable
fun UpdateNoteTopBar(
    viewModel: NoteViewModel = hiltViewModel(),
    note: Note,
    navigateBack: () -> Unit
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

        },
        title = {

        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)