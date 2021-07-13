package com.musicianhelper.di.modules

import com.musicianhelper.MusicianHelperApp
import com.musicianhelper.di.scopes.Application
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@Module(includes = [DispatchersModule::class])
object AppModule {

    @Provides
    @Application
    fun provideApplicationContext(application: MusicianHelperApp) = application

    @Provides
    @ApplicationCoroutineScope
    @Application
    fun providesApplicationScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)


}
