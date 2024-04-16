package com.example.img

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.img.ui.theme.ImgTheme
import com.example.img.ui.theme.MyVModel


class MainActivity : ComponentActivity() {

    private val myModel:MyVModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImgTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val onClick = { myModel.count() }
                    Counter(myModel.counter.value, onClick)
                }
            }
        }
    }
}

@Composable
fun Counter(i: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .background(Color(0xFF08E3FF))
    ) {
        Button(
            onClick = onClick,

        ) {
            Text(text = "The number is $i")
        }
    }
}
