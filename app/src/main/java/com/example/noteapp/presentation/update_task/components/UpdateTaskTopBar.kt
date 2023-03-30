package com.example.noteapp.presentation.update_task.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UpdateTaskTopBar(
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Update Task"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        }
    )
}