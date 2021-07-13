package com.musicianhelper.di.modules

import com.musicianhelper.MainActivityInjectorsModule
import com.musicianhelper.auth.AuthActivityInjectorsModule
import dagger.Module

@Module(
    includes = [
        MainActivityInjectorsModule::class,
        AuthActivityInjectorsModule::class
    ]
)
abstract class FeatureModule
