package com.example.noteapp.presentation.update_task.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.home.components.TextFieldApp

@Composable
fun UpdateTaskContent(
    padding: PaddingValues,
    note: Note,
    updateTitle: (title: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateTask: (note: Note) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldApp(
            text = note.title,
            placeholder = "Title",
            onTextValueChange = { task -> updateTitle(task) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextFieldApp(
            text = note.content,
            placeholder = "Title",
            onTextValueChange = { description -> updateDescription(description) }
        )

        Button(
            onClick = {
                updateTask(note)
                navigateBack()
            }
        ) {
            Text(
                text = "Update"
            )
        }


    }

}