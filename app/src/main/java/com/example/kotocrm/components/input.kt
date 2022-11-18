package com.example.kotocrm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input() {
    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        var text by remember { mutableStateOf("Hello") }
        BasicTextField(
            value = text, cursorBrush = SolidColor(Color(0XFF0037FF)),
            onValueChange = { text = it }, modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(15.dp)
        )

    }
}