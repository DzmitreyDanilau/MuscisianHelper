package com.musicianhelper.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class SignInViewModel @Inject constructor(
) : ViewModel() {

    fun logIn() {
        viewModelScope.launch {
//            signInViewModelComponent.emitSignInRequest()
        }
    }
}
