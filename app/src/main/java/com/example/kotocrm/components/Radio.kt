package com.example.kotocrm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotocrm.R

@Composable
fun KotoRadio(value:Boolean,onClick: (isSelected:Boolean)-> Unit){
    val selectIcon = if (value) R.drawable.ic_radio_selected else R.drawable.ic_radio_unselect
    Surface(modifier = Modifier.size(12.dp,12.dp).clickable {
        onClick(!value)
    }) {
        Image(painter = painterResource(id = selectIcon), contentDescription = "Radio")
    }
}