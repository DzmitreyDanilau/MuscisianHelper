package com.musicianhelper.auth.login

import com.mh.authentication.firebase.FirebaseAuthManager
import com.mh.authentication.firebase.UserCredentials
import com.musicianhelper.base.BaseViewModel
import com.musicianhelper.base.DispatchProvider
import com.musicianhelper.base.Event
import com.musicianhelper.domain.auth.LoginAction
import com.musicianhelper.domain.auth.LoginUseCase
import com.musicianhelper.domain.base.Action
import com.musicianhelper.domain.base.Result
import com.musicianhelper.extensions.ofType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@HiltViewModel
class LoginViewModel @Inject constructor(
    dispatchProvider: DispatchProvider,
    private val authManager: FirebaseAuthManager,
    private val updateUser: LoginUseCase
) : BaseViewModel<LoginState>(dispatchProvider, LoginState.Idle) {

    suspend fun regiseter() {
        val user =
            authManager.registerWithEmailAndPassword(UserCredentials("tesd@gmail.com", "123456"))
                .onStart { LoginState.InProgress }

        val updateUser = updateUser
    }


    fun sharedFlow(action: Flow<Action>): Flow<Result> {
        return merge(
            actionFlow.ofType(LoginAction::class.java).ma   p { updateUser. }
        )
    }

    override suspend fun result(eventObservable: Flow<Event>): Flow<Result> {
        return merge(sharedFlow(eventObservable.map(::toAction)))
    }

    override fun processAction(action: Action): Flow<Result> {
        when (action) {
            is LogIn -> {
            }
        }
    }

    private fun sharedFlows(eventFlow: Flow<Action>): Flow<Result> {
        return merge(
        )
    }

    private fun toAction(event: Event): Action {

    }
}

object LogIn : Event
object LogOut : Event