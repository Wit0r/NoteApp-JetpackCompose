package com.example.noteapp.presentation.update_note.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.noteapp.R
import com.example.noteapp.core.NoteConstants.BACK_BUTTON_CD
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.components.BasicTextFieldApp
import com.example.noteapp.presentation.components.TopBarApp
import com.example.noteapp.presentation.components.TopBarStyle
import com.example.noteapp.ui.theme.AppFont

@Composable
fun UpdateNoteTopBar(
    updateTitle: (title: String) -> Unit,
    note: Note,
    navigateBack: () -> Unit
) {
    TopBarApp(
        topBarStyle = TopBarStyle.SMALL,
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    arrow_back_icon,
                    contentDescription = stringResource(BACK_BUTTON_CD)
                )
            }
        },
        title = {
            BasicTextFieldApp(
                value = note.title,
                onValueChange = { title -> updateTitle(title) },
                textStyle = TextStyle(
                    fontFamily = AppFont.great_sailor,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    )
}

private val arrow_back_icon: Painter @Composable get() = painterResource(R.drawable.arrow_back_icon)