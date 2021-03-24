package com.musicianhelper.auth

import com.mh.authentication.firebase.FirebaseAuthManager
import com.musicianhelper.auth.login.LoginFragment
import com.musicianhelper.data.user.UserRepository
import com.musicianhelper.data.user.UserUpdater
import com.musicianhelper.di.modules.DispatchersModule
import com.musicianhelper.di.scopes.ActivityScope
import com.musicianhelper.di.scopes.FragmentScope
import com.musicianhelper.domain.auth.Authentication
import com.musicianhelper.domain.auth.LoginAction
import com.musicianhelper.domain.auth.LoginResult
import com.musicianhelper.domain.auth.LoginUseCase
import com.musicianhelper.domain.base.UseCase
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.CoroutineDispatcher


@Module
abstract class AuthActivityInjectorsModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributeAuthActivity(): AuthActivity

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            FirebaseAuthModule::class,
            AuthUseCaseModule::class,
            AuthRepositoryModule::class,
            AuthenticationFireabaseModule::class
        ]
    )
    abstract fun contributeLoginFragmentInjector(): LoginFragment

}

@Module
object FirebaseAuthModule {

    @Provides
    fun provideFirebaseAuthManager() = FirebaseAuthManager()
}

@Module
object AuthUseCaseModule {

    @Provides
    fun provideUserLoginUseCase(
        auth: Authentication,
        repository: UserUpdater
    ): UseCase<LoginAction, LoginResult> {
        return LoginUseCase(auth, repository)
    }
}

@Module
object AuthRepositoryModule {

    @Provides
    fun privideUserRepository(@DispatchersModule.IO dispatcher: CoroutineDispatcher): UserUpdater {
        return UserRepository(dispatcher)
    }
}

@Module
object AuthenticationFireabaseModule {

    @Provides
    fun provideAuth(): Authentication {
        return FirebaseAuthManager()
    }

}
