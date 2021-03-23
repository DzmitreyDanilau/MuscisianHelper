package com.musicianhelper.auth.login

import androidx.lifecycle.viewModelScope
import com.mh.authentication.firebase.FirebaseAuthManager
import com.mh.authentication.firebase.FirebaseAuthResult
import com.mh.authentication.firebase.UserCredentials
import com.musicianhelper.base.BaseViewModel
import com.musicianhelper.base.Event
import com.musicianhelper.data.user.UserModel
import com.musicianhelper.domain.auth.LoginAction
import com.musicianhelper.domain.base.Result
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class LoginViewModel @Inject constructor(
    mainDispatcher: CoroutineDispatcher,
    private val authManager: FirebaseAuthManager,
    private val updateUser: UseCase<LoginAction>
) : BaseViewModel<LoginState>(mainDispatcher, LoginState.Idle) {


    fun register() {
        viewModelScope.launch {
            val result = authManager.registerWithEmail(UserCredentials("tesd@gmail.com", "123456"))
            saveUser(result)
        }
    }

    private fun result(result: Flow<Result>) {

    }

    fun saveUser(authResult: FirebaseAuthResult) {
        when (authResult) {
            is FirebaseAuthResult.Success -> {
                updateUser.invoke(LoginAction(UserModel(authResult.user?.displayName ?: "")))
            }
        }
    }
}

object LogIn : Event
object LogOut : Event