package com.musicianhelper.di.components

import android.content.Context
import com.musicianhelper.MusicianHelperApp
import com.musicianhelper.di.modules.AppModule
import com.musicianhelper.di.modules.FeatureModule
import com.musicianhelper.di.scopes.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Application
@Component(
    modules = [
        AppModule::class,
        FeatureModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface MuzHelperComponent : AndroidInjector<MusicianHelperApp> {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): MuzHelperComponent
    }
}