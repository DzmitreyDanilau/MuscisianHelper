package com.mh.authentication.firebase

import com.google.firebase.auth.FirebaseUser

sealed class FirebaseAuthResult {
    data class Success(val user: FirebaseUser?) : FirebaseAuthResult()
    class Failed(val error: String? = null) : FirebaseAuthResult()
}
