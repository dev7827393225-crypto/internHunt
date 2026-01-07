package com.example.internhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.internhunt.ui.Profile.Navigation.NavScreen
import com.example.internhunt.ui.Profile.theme.InternHuntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            InternHuntTheme {

               NavScreen()
                }
            }
        }
    }


