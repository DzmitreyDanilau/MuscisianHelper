package com.musicianhelper.auth.login

import com.mh.authentication.firebase.AuthStateUserDataSource
import com.mh.authentication.firebase.AuthenticatedUserInfo
import com.musicianhelper.domain.base.FlowUseCase
import com.musicianhelper.domain.base.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class ObserveUserAuthStateUseCase(
    private val authStateUserDataSource: AuthStateUserDataSource,
    private val externalScope: CoroutineScope,
    private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Any, AuthenticatedUserInfo>(ioDispatcher) {

    override fun execute(parameters: Any): Flow<Result<AuthenticatedUserInfo>> {
        TODO("Not yet implemented")
    }
}