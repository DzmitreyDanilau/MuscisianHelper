package com.musicianhelper.auth

import com.mh.authentication.firebase.FirebaseAuthManager
import com.musicianhelper.auth.login.LoginFragment
import com.musicianhelper.data.user.UserRepository
import com.musicianhelper.data.user.UserUpdater
import com.musicianhelper.di.scopes.ActivityScope
import com.musicianhelper.di.scopes.FragmentScope
import com.musicianhelper.domain.auth.LoginUseCase
import com.musicianhelper.domain.base.UseCase
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


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
            AuthRepositoryModule::class
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
        repository: UserUpdater
    ): UseCase {
        return LoginUseCase(repository)
    }
}

@Module
object AuthRepositoryModule {

    @Provides
    fun privideUserRepository(): UserUpdater {
        return UserRepository()
    }
}
