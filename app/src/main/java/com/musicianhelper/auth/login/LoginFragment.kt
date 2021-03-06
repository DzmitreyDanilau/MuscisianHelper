package com.musicianhelper.auth.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.musicianhelper.R
import com.musicianhelper.base.BaseFragment
import com.musicianhelper.base.Event
import com.musicianhelper.base.StatePresenter
import com.musicianhelper.base.ViewEventFlow
import com.musicianhelper.databinding.FragmentLoginBinding
import com.musicianhelper.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login), ViewEventFlow<LoginState> {

    val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var statePresenter: StatePresenter<LoginStateRenderer, LoginState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scope.launch {
            viewEvents()
                .onEach { }
                .collect()
        }
    }

    override fun event(event: Event) {
        viewModel.viewStates().value = event
    }

    private fun getStateObserver() {
    }

    override fun viewEvents(): Flow<LoginState> {
        TODO("Not yet implemented")
    }
}
