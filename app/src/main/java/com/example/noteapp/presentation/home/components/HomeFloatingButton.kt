package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.DropdownMenuItemApp

@Composable
fun HomeFloatingButton(
    viewModel: NoteViewModel = viewModel(),
    openDialog: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DropdownMenu(
            modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
            expanded = viewModel.expanded,
            onDismissRequest = { viewModel.expanded = false }
        ) {
            DropdownMenuItemApp(
                text = { Text("Add") },
                onClick = openDialog,
                leadingIcon = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null
                    )
                }
            )
            DropdownMenuItemApp(
                text = { Text("Delete All") },
                onClick = {

                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = null
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        FloatingActionButton(
            onClick = { viewModel.expanded = !viewModel.expanded },
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            content = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Edit icon"
                )
            }
        )
    }
}