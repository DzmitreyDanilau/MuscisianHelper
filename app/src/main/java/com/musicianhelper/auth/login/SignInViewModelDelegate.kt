package com.musicianhelper.auth.login

import android.net.Uri
import com.mh.authentication.firebase.AuthenticatedUserInfo
import com.musicianhelper.di.modules.ApplicationCoroutineScope
import com.musicianhelper.di.modules.IODispatcher
import com.musicianhelper.di.modules.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

enum class SignInNavigationAction {
    RequestSignIn, RequestSignOut, ShowNotificationPreferencesDialog
}

interface SignInViewModelDelegate {
    /**
     * Live updated value of the current firebase user
     */
    val userInfo: StateFlow<AuthenticatedUserInfo?>

    /**
     * Live updated value of the current firebase users image url
     */
    val currentUserImageUri: StateFlow<Uri?>

    /**
     * Emits Events when a sign-in event should be attempted or a dialog shown
     */
    val signInNavigationActions: Flow<SignInNavigationAction>

    /**
     * Emits whether or not to show reservations for the current user
     */
    val showReservations: StateFlow<Boolean>

    /**
     * Emit an Event on performSignInEvent to request sign-in
     */
    suspend fun emitSignInRequest()

    /**
     * Emit an Event on performSignInEvent to request sign-out
     */
    suspend fun emitSignOutRequest()

    val userId: Flow<String?>

    /**
     * Returns the current user ID or null if not available.
     */
    val userIdValue: String?

    val isUserSignedIn: StateFlow<Boolean>

    val isUserSignedInValue: Boolean

    val isUserRegistered: StateFlow<Boolean>

    val isUserRegisteredValue: Boolean
}

class FirebaseSignInViewModelDelegate(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    @ApplicationCoroutineScope val applicationScope: CoroutineScope
) : SignInViewModelDelegate {

    override val userInfo: StateFlow<AuthenticatedUserInfo?>
        get() = TODO("Not yet implemented")
    override val currentUserImageUri: StateFlow<Uri?>
        get() = TODO("Not yet implemented")
    override val signInNavigationActions: Flow<SignInNavigationAction>
        get() = TODO("Not yet implemented")
    override val showReservations: StateFlow<Boolean>
        get() = TODO("Not yet implemented")

    override suspend fun emitSignInRequest() {
        TODO("Not yet implemented")
    }

    override suspend fun emitSignOutRequest() {
        TODO("Not yet implemented")
    }

    override val userId: Flow<String?>
        get() = TODO("Not yet implemented")
    override val userIdValue: String?
        get() = TODO("Not yet implemented")
    override val isUserSignedIn: StateFlow<Boolean>
        get() = TODO("Not yet implemented")
    override val isUserSignedInValue: Boolean
        get() = TODO("Not yet implemented")
    override val isUserRegistered: StateFlow<Boolean>
        get() = TODO("Not yet implemented")
    override val isUserRegisteredValue: Boolean
        get() = TODO("Not yet implemented")
}
