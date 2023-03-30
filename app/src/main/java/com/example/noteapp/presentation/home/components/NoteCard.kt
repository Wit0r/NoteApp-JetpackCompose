package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.ui.theme.AppFont


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TaskCard(
    note: Note,
    deleteNote: () -> Unit,
    navigateToUpdateNoteScreen: (noteId: Int) -> Unit
) {

    var pointer by remember { mutableStateOf(false) }
    val context = LocalContext.current

    ElevatedCard(
        modifier = Modifier
            .aspectRatio(1.0f)
            .padding(
                start = 14.dp,
                end = 14.dp,
                top = 14.dp,
                bottom = 14.dp
            ),
        onClick = {
            navigateToUpdateNoteScreen(note.id)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontFamily = AppFont.great_sailor,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}