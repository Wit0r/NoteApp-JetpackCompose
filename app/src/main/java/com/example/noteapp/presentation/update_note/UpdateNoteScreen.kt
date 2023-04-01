package com.example.noteapp.presentation.update_note

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateNoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

}