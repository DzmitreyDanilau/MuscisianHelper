package com.mh.authentication.firebase

sealed class FirebaseAuthResult {
    object Success : FirebaseAuthResult()
    class Failed(val error: String? = null) : FirebaseAuthResult()
}
