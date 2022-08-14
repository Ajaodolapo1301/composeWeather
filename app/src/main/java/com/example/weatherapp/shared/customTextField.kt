package com.example.notes.shared

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


@ExperimentalComposeUiApi
@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    maxLine: Int  = 1,
    backgroundColor : Color = Color.Transparent,
    onImeAction: ()-> Unit = {}
){
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = value, onValueChange = onValueChanged, modifier = modifier,
colors = TextFieldDefaults.textFieldColors(backgroundColor = backgroundColor),
        maxLines =  maxLine,
        label = {
            Text(text = label)
        },


        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),

        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })


        )

}