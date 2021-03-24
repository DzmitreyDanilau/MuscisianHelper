package com.musicianhelper.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.musicianhelper.di.modules.DispatchersModule.Main
import com.musicianhelper.domain.auth.LoginAction
import com.musicianhelper.domain.auth.LoginResult
import com.musicianhelper.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    @Main private val mainDispatcher: CoroutineDispatcher,
    private val updateUser: UseCase<LoginAction, LoginResult>
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(
            mainDispatcher = mainDispatcher,
            updateUser = updateUser,
        ) as T
    }
}
