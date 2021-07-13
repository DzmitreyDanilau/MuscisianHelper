package com.musicianhelper.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mh.authentication.firebase.SignInHandler
import com.musicianhelper.R
import com.musicianhelper.databinding.FragmentDialogSignInBinding
import com.musicianhelper.viewBinding
import dagger.android.support.DaggerDialogFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class SignInDialogFragment : DaggerDialogFragment() {

    @Inject
    lateinit var signInHandler: SignInHandler

    private val signInViewModel: SignInViewModel by viewModels()

    private val binding: FragmentDialogSignInBinding by viewBinding(
        FragmentDialogSignInBinding::bind
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dialog_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                signInViewModel.signInNavigationActions.collect { action ->
//                    if (action == SignInNavigationAction.RequestSignIn) {
//                        activity?.startActivityForResult(
//                            signInHandler.makeSignInIntent(),
//                            REQUEST_CODE_SIGN_IN
//                        )
//                        dismiss()
//                    }
                }
            }
//        }

//        if (showsDialog) {
//            (requireDialog() as AlertDialog).setView(binding.root)
//        }
    }

    companion object {
        const val DIALOG_SIGN_IN = "dialog_sign_in"
        const val REQUEST_CODE_SIGN_IN = 42
    }
}