package com.iagocarvalho.noteapproom.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun FlasCardTextFild(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxline: Int,
    OntextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
) {
    val keybordControl = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        colors = TextFieldDefaults.outlinedTextFieldColors(Color.Black),
        onValueChange = OntextChange,
        maxLines = maxline,
        label = { Text(text = label) },
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keybordControl?.hide()
        }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        modifier = modifier
    )
}

@Composable
fun FlasCardButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enable: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enable,
        modifier = modifier
    ) {
        Text(text = text)
    }
}


@Preview(showBackground = true)
@Composable
fun FlasCardTextFildPreview() {

}