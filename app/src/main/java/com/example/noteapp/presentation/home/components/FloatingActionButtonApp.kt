package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.presentation.MainViewModel

@Composable
fun FloatingActionButtonApp(
    viewModel: MainViewModel = viewModel(),
    openDialog: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DropdownMenu(
            expanded = viewModel.expanded,
            onDismissRequest = { viewModel.expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                }
            )
            DropdownMenuItem(
                text = { Text("Delete") },
                onClick = {  },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                }
            )
            DropdownMenuItem(
                text = { Text("Add") },
                onClick = openDialog,
                leadingIcon = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        FloatingActionButton(
            onClick = {
                viewModel.expanded = !viewModel.expanded
            },
            content = {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit icon"
                )
            }
        )
    }
}