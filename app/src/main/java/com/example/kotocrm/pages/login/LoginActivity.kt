package com.example.kotocrm.pages.login

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.kotocrm.R
import com.example.kotocrm.components.Input
import com.example.kotocrm.utils.setTransparent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransparent(this);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
//        actionBar?.hide()
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFF0F4FA))) {
                Banner()
                LoginForm()
            }
        }
    }

}

@Composable
fun LoginForm(){
        Input()
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .height(270.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.im_login_bg),
            contentDescription = "login_bg"
        )
        Column(modifier = Modifier.offset(30.dp, 135.dp)) {
            Text(
                text = "账号登录",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier
                .height(12.dp)
                .fillMaxWidth())
            Text(
                text = "Login please".toUpperCase(),
                color = Color.White,
                letterSpacing = 6.sp,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )

        }
    }
}