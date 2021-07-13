package com.musicianhelper

import androidx.lifecycle.ViewModel
import com.mh.authentication.firebase.tryToSend
import com.musicianhelper.auth.login.SignInViewModelDelegate
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class MainActivityViewModel(
//    private val signInViewModelComponent: SignInViewModelDelegate
) : ViewModel() {

    private val _navigationActions = Channel<MainNavigationAction>(Channel.CONFLATED)
    val navigationActions = _navigationActions.receiveAsFlow()

}

sealed class MainNavigationAction {
    object OpenSignIn : MainNavigationAction()
    object OpenSignOut : MainNavigationAction()
}