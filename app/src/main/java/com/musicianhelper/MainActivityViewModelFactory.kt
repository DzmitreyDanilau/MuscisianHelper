package com.musicianhelper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.musicianhelper.auth.login.SignInViewModelDelegate
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(
//    private val signInViewModelComponent: SignInViewModelDelegate
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel() as T
    }
}

