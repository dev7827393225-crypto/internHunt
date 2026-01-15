package com.example.internhunt.ui.Profile.profileScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.internhunt.R
import com.example.internhunt.ui.Profile.Navigation.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){}

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.pag2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }

}