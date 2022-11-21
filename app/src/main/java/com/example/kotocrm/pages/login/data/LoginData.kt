package com.example.kotocrm.pages.login.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LoginResqModel() {
    var userName by mutableStateOf("")
    var passWord by mutableStateOf("")
}