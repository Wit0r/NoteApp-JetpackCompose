package com.example.noteapp.presentation.update_task

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.MainViewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.noteapp.presentation.update_task.components.UpdateTaskContent
import com.example.noteapp.presentation.update_task.components.UpdateTaskTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateTaskScreen(
    viewModel: MainViewModel = hiltViewModel(),
    taskId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getNote(taskId)
    }

    Scaffold(
        topBar = {
            UpdateTaskTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateTaskContent(
                padding = padding,
                note = viewModel.note,
                updateTitle = { title -> viewModel.updateTitle(title) },
                updateDescription = { description ->  viewModel.updateContent(description) },
                updateTask = { task -> viewModel.updateNote(task) },
                navigateBack = navigateBack
            )
        }
    )

}