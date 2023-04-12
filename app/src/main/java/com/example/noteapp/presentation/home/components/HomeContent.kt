@file:OptIn(ExperimentalAnimationApi::class)

package com.example.noteapp.presentation.home.components

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.repository.Notes

@Composable
fun HomeContent(
    padding: PaddingValues,
    notes: Notes,
    navigateToContentScreen: (noteId: Int) -> Unit
) {

    val (visibleNotes, setVisibleNotes) = remember { mutableStateOf(notes) }

    AnimatedContent(
        targetState = visibleNotes,
        modifier = Modifier.fillMaxSize(),
        transitionSpec = {
            ContentTransform(
                fadeIn(
                    tween(500, 50, FastOutSlowInEasing)
                ),
                fadeOut(
                    tween(500, 50, FastOutSlowInEasing)
                )
            )
        }
    ) { targetNotes ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            columns = GridCells.Adaptive(minSize = 164.dp),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            items(targetNotes) { note ->
                HomeCard(
                    note = note,
                    navigateToContentScreen = navigateToContentScreen
                )
            }
        }
    }

    LaunchedEffect(notes) {
        if (notes.size > visibleNotes.size) setVisibleNotes(notes)
    }

}

/*
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
 */