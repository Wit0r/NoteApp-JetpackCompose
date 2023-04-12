package com.example.noteapp.presentation.note_content.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.ui.theme.AppFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NoteContent(
    padding: PaddingValues,
    note: Note,
    viewModel: NoteViewModel = hiltViewModel()
) {

    val noteState by viewModel.noteState.collectAsState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(14.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = (note.title),
            style = TextStyle(
                fontFamily = AppFont.great_sailor,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                color = MaterialTheme.colorScheme.secondary
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn {
            item {
                Text(
                    text = note.content,
                    style = TextStyle(
                        fontFamily = AppFont.great_sailor,
                        textAlign = TextAlign.Start,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        letterSpacing = 0.8.sp,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }

    LaunchedEffect(noteState.isEdited) {
        scope.launch {
            if (noteState.isEdited) {
                delay(30)
                viewModel.resetNoteState()
            }
        }
    }

}