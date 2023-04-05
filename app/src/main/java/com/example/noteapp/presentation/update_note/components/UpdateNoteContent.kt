package com.example.noteapp.presentation.update_note.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.components.TextFieldApp
import com.example.noteapp.ui.theme.AppFont

@Composable
fun UpdateNoteContent(
    padding: PaddingValues,
    note: Note,
    updateTitle: (title: String) -> Unit,
    updateContent: (content: String) -> Unit,
    updateNote: (note: Note) -> Unit,
    navigateBack: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        contentAlignment = Alignment.BottomEnd
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            TextFieldApp(
                value = note.title,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = note.title) },
                textStyle = TextStyle(
                    fontFamily = AppFont.great_sailor,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    color = MaterialTheme.colorScheme.secondary
                ),
                onTextValueChange = { title -> updateTitle(title) },
            )

            TextFieldApp(
                value = note.content,
                modifier = Modifier.fillMaxSize(),
                placeholder = { Text(text = note.content) },
                textStyle = TextStyle(
                    fontFamily = AppFont.great_sailor,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    letterSpacing = 0.8.sp,
                    lineHeight = 24.sp
                ),
                onTextValueChange = { content -> updateContent(content) },
            )

            Spacer(modifier = Modifier.weight(1f))

        }

        Button(
            modifier = Modifier.fillMaxWidth().height(65.dp),
            onClick = { updateNote(note) }
        ) {
            Text(text = "Edit")
        }

    }
}