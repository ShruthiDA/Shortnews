package com.mlsg.shortnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mlsg.shortnews.ui.navigation.AppNavigationGraph
import com.mlsg.shortnews.ui.theme.ShortnewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ShortnewsTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    ShortNewsEntryPoint()
                }
            }
        }
    }
}

@Composable
fun ShortNewsEntryPoint(){
    AppNavigationGraph()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShortnewsTheme {

    }
}