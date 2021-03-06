package com.musicianhelper.auth.login

import com.musicianhelper.base.StateRenderer
import javax.inject.Inject

class LoginStateRenderer @Inject constructor(
    private val fragment: LoginFragment
) : StateRenderer {

    fun render(state: LoginState.Idle) {

    }

    fun render(state: LoginState.InProgress) {

    }

    fun render(state: LoginState.LoggedIn) {
        fragment.event(LogIn)
    }

    fun render(state: LoginState.Error) {
    }

}