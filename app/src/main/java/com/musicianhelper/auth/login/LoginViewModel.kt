package com.musicianhelper.auth.login

import android.service.autofill.UserData
import androidx.lifecycle.viewModelScope
import com.mh.authentication.firebase.FirebaseAuthResult
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
        }
    }

    private fun result(result: Flow<Result>) {

    }

    fun saveUser(authResult: FirebaseAuthResult) {
        when (authResult) {
            is FirebaseAuthResult.Success -> {
//                updateUser.invoke(LoginAction(UserModel(authResult.user?.displayName ?: "")))
            }
        }
    }
}

object LogIn : Event
object LogOut : Event