package com.example.noteapp.presentation.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.noteapp.presentation.components.TopBarApp
import com.example.noteapp.ui.theme.AppFont

@Composable
fun HomeTopBar() {
    TopBarApp(
        title = {
            Text(
                text = "Note",
                fontFamily = AppFont.great_sailor
            )
        }
    )
}