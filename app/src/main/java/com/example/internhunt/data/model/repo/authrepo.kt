package com.example.internhunt.data.model.repo


//import com.example.internhunt.data.remote.FirebaseAuthSource
import com.example.internhunt.data.model.remote.FirebaseAuthSource
import com.google.firebase.auth.FirebaseUser

class AuthRepository(
    private val authSource: FirebaseAuthSource
) {

    suspend fun login(
        email: String,
        password: String
    ): Result<FirebaseUser> {
        return authSource.login(email, password)
    }

    suspend fun signup(
        email: String,
        password: String
    ): Result<FirebaseUser> {
        return authSource.signup(email, password)
    }

    fun getCurrentUser(): FirebaseUser? {
        return authSource.getCurrentUser()
    }
    fun isUserLoggedIn(): Boolean {
        return authSource.getCurrentUser() != null
    }
    fun logout() {
        authSource.logout()
    }
}
