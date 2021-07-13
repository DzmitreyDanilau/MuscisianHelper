package com.musicianhelper.di.modules

import com.musicianhelper.di.scopes.Application
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatchersModule {

    @Application
    @Provides
    @IODispatcher
    fun provideIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Application
    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Application
    @Provides
    @DefaultDispatcher
    fun provideComputationDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}
