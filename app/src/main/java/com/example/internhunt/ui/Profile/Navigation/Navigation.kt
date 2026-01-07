package com.example.internhunt.ui.Profile.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internhunt.data.model.AuthRepository
import com.example.internhunt.data.model.FirebaseAuthSource
import com.example.internhunt.ui.Profile.Home.HomeScreen
import com.example.internhunt.ui.Profile.auth.LoginScreen
import com.example.internhunt.ui.Profile.profileScreen.ProfileScreen
//import com.example.internhunt.Profile.JobDetailScreen
import com.example.internhunt.ui.Profile.Saved.SavedJobScreen
import com.example.internhunt.ui.Profile.Search.SearchScreen
import com.example.internhunt.ui.Profile.auth.Sign_inScreen
import com.example.internhunt.ui.auth.AuthViewModel
import com.example.internhunt.ui.auth.AuthViewModelFactory

@Composable
fun NavScreen() {
    val navController= rememberNavController()
    val authSource = FirebaseAuthSource()
    val authRepository = AuthRepository(authSource)

    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(authRepository)
    )

    val isLoggedIn = authViewModel.isUserLoggedIn()
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "home" else "login"
    )  {
        composable("home") {
            HomeScreen(navController)
        }
        composable("jobdetail") {
            ProfileScreen(navController)
        }
        composable("saved") {
            SavedJobScreen(navController)
        }
        composable("search") {
            SearchScreen(navController)
        }
        composable("login") {
    LoginScreen(navController)
}
       composable("signup") {
    Sign_inScreen(navController)
}
    }
}