package com.example.noteapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.noteapp.ui.theme.AppFont

@Composable
fun TextFieldApp(
    text: String,
    placeholder: String,
    onTextValueChange: (newValue: String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
    ) {

    OutlinedTextField(
        value = text,
        onValueChange = { newValue -> onTextValueChange(newValue) },
        singleLine = true,
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = AppFont.great_sailor
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colorScheme.onBackground)
    )

}