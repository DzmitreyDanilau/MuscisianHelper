package com.musicianhelper.di.modules

import com.musicianhelper.auth.AuthActivityInjectorsModule
import dagger.Module

@Module(includes = [AuthActivityInjectorsModule::class])
abstract class FeatureModule
