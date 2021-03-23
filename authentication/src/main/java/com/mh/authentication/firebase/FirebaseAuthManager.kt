package com.mh.authentication.firebase

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

@Suppress("JAVA_CLASS_ON_COMPANION")
class FirebaseAuthManager {

    companion object {
        private val TAG = FirebaseAuthManager.javaClass.name
    }

    private val firebaseAuth = Firebase.auth

    fun getCurrentFirebaseUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    suspend fun googleAuthForFirebase(credentials: AuthCredential?): FirebaseUser? {
        return credentials?.let {
            authWithGoogle(credentials)
        }
    }

    suspend fun registerWithEmail(userCredentials: UserCredentials): FirebaseUser {
        return authWithEmailAndPassword(userCredentials)

    }

    suspend fun loginInWithEmailAndPassword(userCredentials: UserCredentials): FirebaseUser {
        return signInWithEmailAndPassword(userCredentials)
    }

    private suspend fun authWithGoogle(credentials: AuthCredential): FirebaseUser {
        firebaseAuth
            .signInWithCredential(credentials)
            .await()
        return firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
    }

    private suspend fun authWithEmailAndPassword(userCredentials: UserCredentials): FirebaseUser {
        return try {
            firebaseAuth
                .createUserWithEmailAndPassword(userCredentials.email, userCredentials.password)
                .await()
            firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
        } catch (e: Exception) {
            val message = e.message
            firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
        }
    }

    private suspend fun signInWithEmailAndPassword(userCredentials: UserCredentials): FirebaseUser {
        firebaseAuth
            .signInWithEmailAndPassword(userCredentials.email, userCredentials.password)
            .await()
        return firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
    }
}