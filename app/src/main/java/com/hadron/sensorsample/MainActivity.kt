package com.hadron.sensorsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hadron.sensorsample.ui.theme.SensorSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorSampleTheme {
                // A surface container using the 'background' color from the theme

                val viewModel  = viewModel<MainViewModel>()
                val isDark = viewModel.isDark
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                        .background(
                            if (isDark) Color.DarkGray else Color.White
                        ),

                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isDark) {
                            "dark :)"
                        } else {
                            "light :("
                        },
                        color = if (isDark) Color.White else Color.Black

                    )
                }

            }

        }
    }
}
//}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SensorSampleTheme {
//        Greeting("Android")
//    }
//}