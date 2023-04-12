package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.ui.theme.AppFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCard(
    note: Note,
    navigateToContentScreen: (noteId: Int) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .aspectRatio(1.0f)
            .padding(14.dp),
        onClick = { navigateToContentScreen(note.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontFamily = AppFont.great_sailor,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}