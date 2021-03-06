package com.musicianhelper.domain.auth

import com.musicianhelper.data.user.UserModel
import com.musicianhelper.data.user.UserUpdater
import com.musicianhelper.domain.base.Action
import com.musicianhelper.domain.base.Result
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class LoginUseCase(private val repository: UserUpdater) : UseCase<LoginAction, LoginResult> {
    /**
     * Collects the value emitted by the upstream.
     * This method is not thread-safe and should not be invoked concurrently.
     */
    override suspend fun emit(value: LoginAction) {
        TODO("Not yet implemented")
    }

    suspend operator fun invoke(action: LoginAction) = repository.updateUser(user)
}

data class LoginAction(val user: UserModel) : Action
sealed class LoginResult : Result {
    object InProgress : LoginResult()
    object Success : LoginResult()
    data class Error(val error: String) : LoginResult()
}