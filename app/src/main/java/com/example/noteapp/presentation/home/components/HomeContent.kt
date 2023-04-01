package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    navigateToContentScreen: (noteId: Int) -> Unit,
    greetingViewModel: GreetingViewModel = hiltViewModel()
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        columns = GridCells.Adaptive(minSize = 164.dp),
        verticalArrangement = Arrangement.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        item {

            val context = LocalContext.current
            val greeting by greetingViewModel.greeting.collectAsState()

            Column(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = greeting)
                }
            )
        }
        items(notes) { note ->
            HomeCard(
                note = note,
                navigateToContentScreen = navigateToContentScreen
            )
        }
    }
}