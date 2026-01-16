package com.example.internhunt.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.internhunt.data.model.repo.AuthRepository
//import com.example.internhunt.data.repository.AuthRepository
//import com.example.internhunt.utils.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
var name= MutableStateFlow("")
    var fullName= name.asStateFlow()
    fun updateName(newName:String){
        name.value=newName
    }

    var mobile= MutableStateFlow("")
    var num=mobile.asStateFlow()
    fun updateMobile(newMobile:String){
        mobile.value=newMobile
    }



    var authState by mutableStateOf<Resource<FirebaseUser>>(Resource.Idle)
        private set

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            authState = Resource.Error("Email and password cannot be empty")
            return
        }

        viewModelScope.launch {
            authState = Resource.Loading

            authState = authRepository.login(email, password)
                .fold(
                    onSuccess = { Resource.Success(it) },
                    onFailure = {
                        Resource.Error(it.message ?: "Login failed")
                    }
                )
        }
    }

    fun signup(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            authState = Resource.Error("Email and password cannot be empty")
            return
        }

        if (password.length < 6) {
            authState = Resource.Error("Password must be at least 6 characters")
            return
        }

        viewModelScope.launch {
            authState = Resource.Loading

            authState = authRepository.signup(email, password)
                .fold(
                    onSuccess = { Resource.Success(it) },
                    onFailure = {
                        Resource.Error(it.message ?: "Signup failed")
                    }
                )
        }
    }
fun logout() {
    authRepository.logout()
}
    fun resetState() {
        authState = Resource.Idle
    }
    fun isUserLoggedIn(): Boolean {
        return authRepository.isUserLoggedIn()
    }

}
class AuthViewModelFactory(
    private val repository: AuthRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    object Idle : Resource<Nothing>()
}
