package com.example.kotocrm.pages.login

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.kotocrm.R
import com.example.kotocrm.components.Input
import com.example.kotocrm.components.InputType
import com.example.kotocrm.components.KotoRadio
import com.example.kotocrm.pages.login.data.LoginResqModel
import com.example.kotocrm.utils.ToastMsg
import com.example.kotocrm.utils.setTransparent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransparent(this)

        val context = this

        var loginResq = LoginResqModel()

        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0XFFF0F4FA))
            ) {
                Banner()
                LoginForm(context, loginResq) {
                    handleLogin()
                }
            }
        }
    }

    private fun handleLogin() {
        Log.i("KotoCrm", "?????????")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(context: Context, loginResqModel: LoginResqModel, submit: () -> Unit) {
    var isAgree by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .offset(y = 239.dp)
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
    ) {
        Input(text = loginResqModel.userName, placeholder = "??????????????????", onChange = {
            loginResqModel.userName = it
        })
        Spacer(modifier = Modifier.height(20.dp))
        Input(
            text = loginResqModel.passWord,
            placeholder = "?????????6-16?????????",
            type = InputType.PASSWORD,
            onChange = {
                loginResqModel.passWord = it
            })
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                if (isAgree) {
                    submit()
                } else {
                    ToastMsg(context, "????????????????????????????????????????????????")
                }

            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF0037FF),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "??????",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 3.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))



        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconToggleButton(
                checked = isAgree,
                onCheckedChange = { isAgree = !isAgree },
                modifier = Modifier.offset(x = 12.dp)
            ) {
                Image(
                    painter = painterResource(id = if (isAgree) R.drawable.ic_radio_selected else R.drawable.ic_radio_unselect),
                    contentDescription = "Radio icon",
                    modifier = Modifier.size(12.dp),
                )
            }
            Row() {
                Text(text = "??????????????????", fontSize = 12.sp, fontWeight = FontWeight.W400)
                Text(text = "??????????????????", fontSize = 12.sp, color = Color(0XFF0037FF))
                Text(text = "???", fontSize = 12.sp)
                Text(text = "??????????????????", fontSize = 12.sp, color = Color(0XFF0037FF))
            }
        }
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .height(270.dp)
            .fillMaxWidth()
    ) {
        // ?????????
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.im_login_bg),
            contentDescription = "login_bg"
        )
        // ??????????????????icon
        Image(
            modifier = Modifier
                .size(95.dp, 170.dp)
                .offset(240.dp, 68.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.im_login_person),
            contentDescription = "login_person"
        )

        // ????????????
        Column(modifier = Modifier.offset(30.dp, 135.dp)) {
            Text(
                text = "????????????",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier
                    .height(12.dp)
                    .fillMaxWidth()
            )
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