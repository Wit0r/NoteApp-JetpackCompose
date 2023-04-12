package com.example.noteapp.presentation.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.noteapp.core.HomeConstants.APP_NAME
import com.example.noteapp.presentation.components.TopBarApp
import com.example.noteapp.presentation.components.TopBarStyle
import com.example.noteapp.ui.theme.AppFont

@Composable
fun HomeTopBar() {
    TopBarApp(
        topBarStyle = TopBarStyle.CENTER,
        title = {
            Text(
                text = stringResource(APP_NAME),
                fontFamily = AppFont.great_sailor
            )
        }
    )
}