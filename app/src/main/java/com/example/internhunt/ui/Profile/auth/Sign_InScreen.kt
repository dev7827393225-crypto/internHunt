package com.example.internhunt.ui.Profile.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.internhunt.R
import com.example.internhunt.ui.auth.AuthViewModel
import com.example.internhunt.ui.auth.Resource
import androidx.compose.runtime.collectAsState
import com.example.internhunt.data.model.repo.AuthRepository
import com.example.internhunt.data.model.remote.FirebaseAuthSource
import com.example.internhunt.ui.auth.AuthViewModelFactory

@Composable
fun Sign_inScreen(
    navController: NavHostController,

) {
    val authSource = remember { FirebaseAuthSource() }
    val authRepository = remember { AuthRepository(authSource) }

    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(authRepository)
    )

    //var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //  Observe auth state
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
                "Sign_up",
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
            .padding(top = 240.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = authViewModel.name.collectAsState().value,
            onValueChange = { authViewModel.updateName(it)},
            label = { Text("Full Name") },
            leadingIcon = { Icon(Icons.Default.Person, null) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = authViewModel.num.collectAsState().value,
            onValueChange = { authViewModel.updateMobile(it) },
            label = { Text("Mobile No") },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Phone, null) }
        )

        Spacer(modifier = Modifier.height(8.dp))

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
                //  Call ViewModel
                authViewModel.signup(email, password)
            },
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A39CE))
        ) {
            Text(
                "Sign_up",
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        //    Handle auth state
        when (authState) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                // Navigate after successful signup
                LaunchedEffect(Unit) {
                    navController.navigate("home") {
                        popUpTo("signup") { inclusive = true }
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

        Row {
            Text("Already have an account?")
            Text(
                " Login",
                modifier = Modifier.clickable {
                    navController.navigate("login")
                },
                color = Color.Blue
            )
        }
    }
}
