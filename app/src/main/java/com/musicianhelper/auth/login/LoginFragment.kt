package com.musicianhelper.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.musicianhelper.R
import com.musicianhelper.base.BaseFragment
import com.musicianhelper.base.StatePresenter
import com.musicianhelper.base.ViewEventFlow
import com.musicianhelper.databinding.FragmentLoginBinding
import com.musicianhelper.viewBinding
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.fragment_login), ViewEventFlow<LoginState> {

    val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    private lateinit var statePresenter: StatePresenter<LoginStateRenderer, LoginState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    fun login() {
        viewModel.register()
    }

    private fun getStateObserver() {
    }

    override fun viewEvents(): Flow<LoginState> {
        TODO("Not yet implemented")
    }
}
