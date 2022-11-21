package com.example.kotocrm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotocrm.pages.login.LoginActivity
import com.example.kotocrm.ui.theme.KotoCrmTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KotoCrmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        Button(onClick = { openLoginPage() }, modifier = Modifier.size(100.dp,30.dp)) {
                            Text(text = "LOGIN")
                        }
                    }

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        openLoginPage()
    }

    private fun openLoginPage() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        this.startActivity(loginIntent)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotoCrmTheme {
        Greeting("Android")
    }
}