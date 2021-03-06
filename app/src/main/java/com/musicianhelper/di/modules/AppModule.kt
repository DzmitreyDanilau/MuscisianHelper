package com.musicianhelper.di.modules

import com.musicianhelper.auth.AuthModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [AuthModule::class])
object AppModule