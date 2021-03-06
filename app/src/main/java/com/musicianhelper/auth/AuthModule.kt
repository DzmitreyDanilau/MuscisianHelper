package com.musicianhelper.auth

import com.mh.authentication.firebase.FirebaseAuthManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AuthModule {

    @Provides
    fun provideFirebaseAuthManager() = FirebaseAuthManager()
}