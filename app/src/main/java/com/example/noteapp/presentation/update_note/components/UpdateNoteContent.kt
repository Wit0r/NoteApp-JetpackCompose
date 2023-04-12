package com.example.noteapp.presentation.update_note.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.core.NoteConstants.EDIT_NOTE_CD
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.NoteViewModel
import com.example.noteapp.presentation.components.BasicTextFieldApp
import com.example.noteapp.ui.theme.AppFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UpdateNoteContent(
    padding: PaddingValues,
    note: Note,
    updateContent: (content: String) -> Unit,
    updateNote: (note: Note) -> Unit,
    viewModel: NoteViewModel= hiltViewModel(),
    navigateBack: () -> Unit
) {

    val focusRequester = FocusRequester()
    val noteState by viewModel.noteState.collectAsState()
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            BasicTextFieldApp(
                value = note.content,
                onValueChange = { content -> updateContent(content) },
                textStyle = TextStyle(
                    fontFamily = AppFont.great_sailor,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Thin,
                    letterSpacing = 0.8.sp,
                    lineHeight = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .weight(0.3f)
                    .focusRequester(focusRequester)
            )

            Button(
                modifier = Modifier
                    .aspectRatio(10.0f),
                shape = RoundedCornerShape(0.dp),
                onClick = { updateNote(note)}
            ) {
                Text(
                    text = stringResource(EDIT_NOTE_CD),
                    fontFamily = AppFont.great_sailor,
                    textAlign = TextAlign.Start,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    LaunchedEffect(focusRequester) {
        focusRequester.requestFocus()
    }

    LaunchedEffect(noteState.isEdited) {
        scope.launch {
            if (noteState.isEdited) {
                navigateBack()
            }
        }
    }

}