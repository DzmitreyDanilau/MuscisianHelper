package com.musicianhelper.auth

import com.mh.authentication.firebase.FirebaseAuthSignInHandler
import com.mh.authentication.firebase.SignInHandler
import com.musicianhelper.auth.login.SignInDialogFragment
import com.musicianhelper.di.modules.ApplicationCoroutineScope
import com.musicianhelper.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.CoroutineScope

@Module
abstract class AuthActivityInjectorsModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            FirebaseAuthModule::class,
            AuthenticationFirebaseModule::class,
            SignInIntentHandler::class
        ]
    )
    abstract fun contributeLoginFragmentInjector(): SignInDialogFragment

}

@Module
object FirebaseAuthModule {
}

@Module
object AuthenticationFirebaseModule {
}

@Module
object SignInIntentHandler {

    @Provides
    fun provideSignInHandler(
        @ApplicationCoroutineScope externalScope: CoroutineScope
    ): SignInHandler {
        return FirebaseAuthSignInHandler(externalScope)
    }
}

