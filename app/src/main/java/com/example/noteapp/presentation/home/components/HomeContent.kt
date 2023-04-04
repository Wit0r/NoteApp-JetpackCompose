package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.repository.Notes

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