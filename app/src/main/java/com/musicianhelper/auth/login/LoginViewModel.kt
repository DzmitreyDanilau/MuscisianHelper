package com.musicianhelper.auth.login

import androidx.lifecycle.viewModelScope
import com.musicianhelper.base.BaseViewModel
import com.musicianhelper.base.Event
import com.musicianhelper.data.user.UserModel
import com.musicianhelper.domain.auth.LoginAction
import com.musicianhelper.domain.auth.LoginResult
import com.musicianhelper.domain.base.Result
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class LoginViewModel @Inject constructor(
    mainDispatcher: CoroutineDispatcher,
    private val updateUser: UseCase<LoginAction, LoginResult>
) : BaseViewModel<LoginState>(mainDispatcher, LoginState.Idle) {

    fun register() {
        viewModelScope.launch {
            updateUser.invoke(LoginAction(UserModel("")))
                .map {
                    when (it) {
                        is LoginResult.Success -> {
                            viewState.emit(LoginState.LoggedIn("Dima"))
                        }
                        is LoginResult.Error -> {
                            viewState.emit(LoginState.Error(it.error))
                        }
                        is LoginResult.InProgress -> {
                            viewState.emit(LoginState.InProgress)
                        }
                    }
                }
                .stateIn(viewModelScope)
        }
    }

    private fun result(result: Flow<Result>) {

    }
}

object LogIn : Event
object LogOut : Event