package com.example.noteapp.presentation.note_content.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.R
import com.example.noteapp.presentation.MainViewModel
import com.example.noteapp.presentation.components.DropdownMenuItemApp

@Composable
fun NoteContentTopBar(
    navigateBack: () -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
    openDialog: Boolean
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    arrow_back_icon,
                    contentDescription = "Back to home screen"
                )
            }
        },
        actions = {
            IconButton(
                onClick = { viewModel.expanded = !viewModel.expanded }
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit Note"
                )
            }

            IconButton(
                onClick = { viewModel.openDialog() }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Delete Note"
                )
            }

            DropdownMenu(
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                expanded = viewModel.expanded,
                onDismissRequest = { viewModel.expanded = false }
            ) {
                DropdownMenuItemApp(
                    text = { Text("Add") },
                    onClick = {},
                    leadingIcon = {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = null
                        )
                    }
                )
            }

        },
        title = {},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            scrolledContainerColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)