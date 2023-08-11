package com.olashiku.kmmtemplate.android.views.Reusables

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.olashiku.kmmtemplate.android.resource.Colors
import com.olashiku.kmmtemplate.android.resource.Fonts

@Composable
fun EditText(
    modifier: Modifier = Modifier, textState: MutableState<String>, label: String,
    isEnabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) { // #
    OutlinedTextField(
        modifier = modifier,
        enabled = isEnabled,
        value = textState.value,
        onValueChange = { textState.value = it },
        label = {
            Text(
                label, style = Fonts.Typography.body1,
                fontSize = 14.sp
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        singleLine = isSingleLine,
        textStyle = Fonts.Typography.body1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(Colors.editTextColor),
            unfocusedBorderColor = Color(Colors.edittextLineColor),
            focusedBorderColor = Color(Colors.lightBrownColor)

        )
    )
}

@Composable
fun EditTextPassword(
    modifier: Modifier = Modifier,
    textState: MutableState<String>,
    label: String,
    isEnabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        enabled = isEnabled,
        value = textState.value,
        visualTransformation = if (passwordVisible) VisualTransformation
            .None else PasswordVisualTransformation(),
        onValueChange = {
            textState.value = it
        },
        label = {
            Text(
                text = label, style = Fonts.Typography.body1,
                fontSize = 14.sp
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        singleLine = isSingleLine,
        maxLines = 1,
        textStyle = Fonts.Typography.body1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(Colors.editTextColor),
            unfocusedBorderColor = Color(Colors.edittextLineColor),
            focusedBorderColor = Color(Colors.lightBrownColor)

        ),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        }
    )
}





