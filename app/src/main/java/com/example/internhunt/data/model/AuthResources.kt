package com.example.internhunt.data.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirebaseAuthSource {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(
        email: String,
        password: String
    ): Result<FirebaseUser> =
        suspendCancellableCoroutine { cont ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    cont.resume(Result.success(it.user!!))
                }
                .addOnFailureListener {
                    cont.resume(Result.failure(it))
                }
        }

    suspend fun signup(
        email: String,
        password: String
    ): Result<FirebaseUser> =
        suspendCancellableCoroutine { cont ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    cont.resume(Result.success(it.user!!))
                }
                .addOnFailureListener {
                    cont.resume(Result.failure(it))
                }
        }

    fun getCurrentUser(): FirebaseUser? = auth.currentUser

    fun logout() {
        auth.signOut()
    }
}
