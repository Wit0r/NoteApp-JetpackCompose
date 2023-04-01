package com.example.noteapp.presentation.update_note.components

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
import com.example.noteapp.R
import com.example.noteapp.presentation.components.DropdownMenuItemApp
import com.example.noteapp.presentation.components.TopBarApp

@Composable
fun UpdateTopBar(
    navigateBack: () -> Unit
) {
    TopBarApp(
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    arrow_back_icon,
                    contentDescription = "Back to home screen"
                )
            }
        },
        title = {
            Text(
                text = "Update"
            )
        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)