package com.musicianhelper.auth.login

import androidx.core.view.isVisible
import com.musicianhelper.base.StateRenderer
import javax.inject.Inject

class LoginStateRenderer @Inject constructor(
    private val fragment: LoginFragment
) : StateRenderer {

    fun render(state: LoginState.Idle) {

    }

    fun render(state: LoginState.InProgress) {
        with(fragment.binding) {
            progressBar.isVisible = true
        }
    }

    fun render(state: LoginState.LoggedIn) {
        with(fragment.binding) {
            progressBar.isVisible = false
            tvUserEmail.text = "Hello Dima"
            btnLogin.isVisible = false
        }
    }

    fun render(state: LoginState.Error) {
        with(fragment.binding) {
            progressBar.isVisible = false
            tvErrorText.text = state.error
            btnLogin.isVisible = false
        }
    }
}