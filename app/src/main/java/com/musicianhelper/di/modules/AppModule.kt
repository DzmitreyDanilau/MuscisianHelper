package com.musicianhelper.di.modules

import com.musicianhelper.MusicianHelperApp
import com.musicianhelper.di.scopes.Application
import dagger.Module
import dagger.Provides

@Module(includes = [DispatchersModule::class])
object AppModule {

    @Provides
    @Application
    fun provideApplicationContext(application: MusicianHelperApp) = application
}
