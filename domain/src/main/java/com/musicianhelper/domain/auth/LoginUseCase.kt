package com.musicianhelper.domain.auth

import com.musicianhelper.data.user.UserModel
import com.musicianhelper.data.user.UserUpdater
import com.musicianhelper.domain.base.Action
import com.musicianhelper.domain.base.Result
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

@FlowPreview
@ExperimentalCoroutinesApi
class LoginUseCase(private val repository: UserUpdater) : UseCase<LoginAction> {

    override suspend fun invoke(action: LoginAction): Flow<Result> {
        return coroutineScope {
            repository.updateUser(UserModel("dasds"))
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
}

data class LoginAction(val user: UserModel) : Action

sealed class LoginResult : Result {
    object InProgress : LoginResult()
    data class Success(val userName: String) : LoginResult()
    data class Error(val error: String) : LoginResult()
}