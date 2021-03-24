package com.musicianhelper.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.musicianhelper.R
import com.musicianhelper.base.BaseFragment
import com.musicianhelper.base.ViewEventFlow
import com.musicianhelper.databinding.FragmentLoginBinding
import com.musicianhelper.viewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.fragment_login), ViewEventFlow<LoginState> {

    val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    @Inject
    lateinit var renderer: LoginStateRenderer

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    fun login() {
        viewModel.register()
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenResumed {
            viewModel.getState().collect {
                when (it) {
                    is LoginState.LoggedIn -> renderer.render(it)
                    is LoginState.InProgress -> renderer.render(it)
                    is LoginState.Error -> renderer.render(it)
                    is LoginState.Idle -> renderer.render(it)
                }
            }

        }
    }

    private fun getStateObserver() {
    }

    override fun viewEvents(): Flow<LoginState> {
        TODO("Not yet implemented")
    }
}
