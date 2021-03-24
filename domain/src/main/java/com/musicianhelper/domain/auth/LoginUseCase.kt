package com.musicianhelper.domain.auth

import com.musicianhelper.data.user.UserModel
import com.musicianhelper.data.user.UserUpdater
import com.musicianhelper.domain.base.Action
import com.musicianhelper.domain.base.Result
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class LoginUseCase constructor(
    private val auth: Authentication,
    private val repository: UserUpdater
) : UseCase<LoginAction, LoginResult> {

    override suspend fun invoke(action: LoginAction): LoginResult {
        subscribe()
        auth.login()
        return LoginResult.Success("")
    }

    suspend fun subscribe() {
        auth.authResult.shareIn(coroutineScope}) {
            when (it) {
                is AuthResult.Success -> updateUser(it.user)
                is AuthResult.Failed -> LoginResult.Error(it.error!!)
            }
        }
    }

    private fun updateUser(user: UserModel?): Flow<LoginResult> {
        return repository.updateUser(UserModel("dasds"))
            .onStart { LoginResult.InProgress }
            .map { result ->
                result.fold(
                    {
                        LoginResult.Success("dasds")
                    },
                    {
                        LoginResult.Error(it.message!!)
                    }
                )
            }.catch { LoginResult.Error(it.message!!) }
    }
}

data class LoginAction(val user: UserModel) : Action

sealed class LoginResult : Result {
    object InProgress : LoginResult()
    data class Success(val userName: String) : LoginResult()
    data class Error(val error: String) : LoginResult()
}