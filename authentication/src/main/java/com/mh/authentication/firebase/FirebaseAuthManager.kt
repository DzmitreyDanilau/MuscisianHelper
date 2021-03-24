package com.mh.authentication.firebase

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.musicianhelper.data.user.UserModel
import com.musicianhelper.domain.auth.AuthResult
import com.musicianhelper.domain.auth.Authentication
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.tasks.await

@Suppress("JAVA_CLASS_ON_COMPANION")
class FirebaseAuthManager : Authentication {

    companion object {
        private val TAG = FirebaseAuthManager.javaClass.name
    }

    private val firebaseAuthResult: MutableSharedFlow<AuthResult> = MutableSharedFlow()

    private val firebaseAuth = Firebase.auth

    override val authResult: SharedFlow<AuthResult> = firebaseAuthResult.asSharedFlow()

    override fun register() {
        TODO("Not yet implemented")
    }

    override suspend fun login() {
        authWithEmailAndPassword(UserCredentials("tesd@gmail.com", "123456"))
    }

    private suspend fun googleAuthForFirebase(credentials: AuthCredential?): FirebaseUser? {
        return credentials?.let {
            authWithGoogle(credentials)
        }
    }

    private suspend fun registerWithEmail(userCredentials: UserCredentials) {
        return authWithEmailAndPassword(userCredentials)

    }

    private suspend fun loginInWithEmailAndPassword(userCredentials: UserCredentials): FirebaseUser {
        return signInWithEmailAndPassword(userCredentials)
    }

    private suspend fun authWithGoogle(credentials: AuthCredential): FirebaseUser {
        firebaseAuth
            .signInWithCredential(credentials)
            .await()
        return firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
    }

    private suspend fun authWithEmailAndPassword(userCredentials: UserCredentials) {
        try {
            firebaseAuth
                .createUserWithEmailAndPassword(userCredentials.email, userCredentials.password)
                .await()
            firebaseAuthResult.emit(
                AuthResult.Success(
                    user = UserModel(
                        firebaseAuth.currentUser?.displayName ?: ""
                    )
                )
            )
        } catch (e: Exception) {
            firebaseAuthResult.emit(AuthResult.Failed(e.message))
        }
    }

    private suspend fun signInWithEmailAndPassword(userCredentials: UserCredentials): FirebaseUser {
        firebaseAuth
            .signInWithEmailAndPassword(userCredentials.email, userCredentials.password)
            .await()
        return firebaseAuth.currentUser ?: throw FirebaseAuthException("", "")
    }
}
