package com.example.internhunt.ui.Profile.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.internhunt.R
import com.example.internhunt.data.model.AuthRepository
import com.example.internhunt.data.model.FirebaseAuthSource
import com.example.internhunt.ui.auth.AuthViewModel
import com.example.internhunt.ui.auth.AuthViewModelFactory
//import com.example.internhunt.data.repository.AuthRepository
//import com.example.internhunt.data.remote.FirebaseAuthSource
import com.example.internhunt.ui.auth.Resource

@Composable
fun LoginScreen(navController: NavHostController) {

    val context = LocalContext.current

    //  Create repository manually
    val authSource = remember { FirebaseAuthSource() }
    val authRepository = remember { AuthRepository(authSource) }

    //  Create ViewModel manually
    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(authRepository)
    )

    // Compose state for text fields
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Observe auth state
    val authState = authViewModel.authState

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.pagee),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img_1),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Text(
                "Login",
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 270.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            leadingIcon = { Icon(Icons.Default.Email, null) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Lock, null) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                // Call ViewModel login function
                if (email.isBlank() || password.isBlank()) {
                    Toast.makeText(context, "Enter email & password", Toast.LENGTH_SHORT).show()
                } else {
                    authViewModel.login(email, password)
                }
            },
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A39CE))
        ) {
            Text(
                "Log in",
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        //  Handle auth state
        when (authState) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                // Navigate on successful login
                LaunchedEffect(Unit) {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }

            is Resource.Error -> {
                Text(
                    text = authState.message,
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            else -> {}
        }

        Spacer(modifier = Modifier.height(7.dp))
        Text(
            "Forget Password?",
            color = Color.Blue,
            modifier = Modifier.clickable {
                // TODO: Implement password reset
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Image(
                painter = painterResource(R.drawable.img_2),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { /* TODO: Google login */ }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { /* TODO: Facebook login */ }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(R.drawable.img_4),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { /* TODO: Apple login */ }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row {
            Text("Don't have an account?")
            Text(
                " Sign_up",
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                },
                color = Color.Blue
            )
        }
    }
}
