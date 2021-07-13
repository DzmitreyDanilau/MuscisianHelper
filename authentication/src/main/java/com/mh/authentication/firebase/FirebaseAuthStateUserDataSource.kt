package com.mh.authentication.firebase

import com.google.firebase.auth.FirebaseAuth
import com.musicianhelper.auth.login.FirebaseUserInfo
import com.musicianhelper.domain.base.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import timber.log.Timber

@Suppress("JAVA_CLASS_ON_COMPANION")
@ExperimentalCoroutinesApi
class FirebaseAuthStateUserDataSource(
    private val firebase: FirebaseAuth,
    private val externalScope: CoroutineScope
) : AuthStateUserDataSource {

    private val userInfo: SharedFlow<Result<AuthenticatedUserInfoBasic?>> =
        callbackFlow<FirebaseAuth> {
            val authStateListener: ((FirebaseAuth) -> Unit) = { auth ->
                // This callback gets always executed on the main thread because of Firebase
                tryToSend(auth)
            }
            firebase.addAuthStateListener(authStateListener)
            awaitClose { firebase.removeAuthStateListener(authStateListener) }
        }.map { authState ->
            processAuthState(authState)
        }.shareIn(
            scope = externalScope,
            replay = 1,
            started = SharingStarted.WhileSubscribed()
        )

    override fun getBasicUserInfo(): Flow<Result<AuthenticatedUserInfoBasic?>> {
        return userInfo
    }


    private fun processAuthState(auth: FirebaseAuth): Result<AuthenticatedUserInfoBasic?> {
        Timber.d("Received a FirebaseAuth update.")
        return Result.Success(FirebaseUserInfo(auth.currentUser))
    }
}


fun <E> SendChannel<E>.tryToSend(element: E): Boolean = try {
    offer(element)
} catch (t: Throwable) {
    false // Ignore
}