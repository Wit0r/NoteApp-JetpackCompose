package com.example.noteapp.presentation.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun TextFieldApp(
    value: String,
    onTextValueChange: (newValue: String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colorScheme.onBackground)
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue -> onTextValueChange(newValue) },
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = MaterialTheme.shapes.small,
        singleLine = singleLine,
        maxLines = maxLines,
        colors = colors

    )

}

//    OutlinedTextField(
//        value = value,
//        onValueChange = { newValue -> onTextValueChange(newValue) },
//        modifier = modifier,
//        placeholder = {
//            Text(
//                text = placeholder,
//                fontFamily = AppFont.great_sailor
//            )
//        },
//        keyboardOptions = keyboardOptions,
//        keyboardActions = keyboardActions,
//        shape = MaterialTheme.shapes.small,
//        singleLine = singleLine,
//        maxLines = maxLines,
//        interactionSource = interactionSource,
//        shape = shape,
//        colors = TextFieldDefaults.outlinedTextFieldColors(MaterialTheme.colorScheme.onBackground)
//    )