package com.example.noteapp.presentation.note_content.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.ui.theme.AppFont

@Composable
fun NoteContent(
    padding: PaddingValues,
    note: Note
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(14.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
      /*  Text(
            text = "Note",
            fontFamily = AppFont.great_sailor,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(8.dp))
*/
        Text(
            text = "${note.title} ${note.id}",
            fontFamily = AppFont.great_sailor,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn {
            item {
                Text(
                    text = note.content,
                    fontFamily = AppFont.great_sailor,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize
                )
            }
        }

    }
}