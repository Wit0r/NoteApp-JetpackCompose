package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.domain.repository.Notes
import com.example.noteapp.presentation.GreetingViewModel
import java.util.Calendar
import java.util.TimeZone

@Composable
fun HomeContent(
    padding: PaddingValues,
    notes: Notes,
    navigateToContentScreen: (noteId: Int) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            columns = GridCells.Adaptive(minSize = 164.dp),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            items(notes) { note ->
                HomeCard(
                    note = note,
                    navigateToContentScreen = navigateToContentScreen
                )
            }
        }
    }


}