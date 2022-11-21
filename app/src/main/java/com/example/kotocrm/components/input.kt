package com.example.kotocrm.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotocrm.R

enum class InputType {
    TEXT, PASSWORD
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(
    text: String,
    placeholder: String = "",
    type: InputType = InputType.TEXT,
    onChange: (value: String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(type != InputType.PASSWORD) }
    var keyboardType = when (type) {
        InputType.TEXT -> KeyboardType.Text
        InputType.PASSWORD -> KeyboardType.Password
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(end = 15.dp)
    ) {
        TextField(
            shape = RoundedCornerShape(8.dp),
            value = text,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                cursorColor = Color.Green,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            placeholder = {
                Text(text = placeholder, fontSize = 14.sp, color = Color(0XFFBFBFBF))
            },
            singleLine = true,
            onValueChange = { onChange(it) }, modifier = Modifier.weight(1F)
        )
        if (type == InputType.PASSWORD) {
            Icon(
                painter = painterResource(id = if (passwordVisible) R.drawable.ic_eye_close else R.drawable.ic_eye_open),
                contentDescription = "eye",
                modifier = Modifier
                    .size(18.dp)
                    .clickable {
                        passwordVisible = !passwordVisible
                    }
                    .background(Color.White)
            )
        }
    }

}