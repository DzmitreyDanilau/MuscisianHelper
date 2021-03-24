package com.musicianhelper.auth.login

import com.musicianhelper.base.State

sealed class LoginState : State<LoginStateRenderer> {

    object Idle : LoginState() {
        override fun accept(stateRenderer: LoginStateRenderer) {
            stateRenderer.render(this)
        }
    }

    data class LoggedIn(val name: String) : LoginState() {
        override fun accept(stateRenderer: LoginStateRenderer) {
            stateRenderer.render(this)
        }
    }

    object InProgress : LoginState() {
        override fun accept(stateRenderer: LoginStateRenderer) {
            stateRenderer.render(this)
        }
    }

    data class Error(val error: String) : LoginState() {
        override fun accept(stateRenderer: LoginStateRenderer) {
            stateRenderer.render(this)
        }
    }
}
