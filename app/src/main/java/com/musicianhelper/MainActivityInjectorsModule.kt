package com.musicianhelper

import com.musicianhelper.di.scopes.ActivityScope
import com.musicianhelper.di.scopes.FragmentScope
import com.musicianhelper.placeslist.RepetitionPlacesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityInjectorsModule {

    @ContributesAndroidInjector(
        modules = [
            RepetitionPlacesFragmentInjectorModule::class
        ]
    )
    @ActivityScope
    abstract fun contributeAuthActivity(): MainActivity
}

@Module
abstract class RepetitionPlacesFragmentInjectorModule {

    @ContributesAndroidInjector(
    )
    @FragmentScope
    abstract fun contributeRepetitionPlacesFragment(): RepetitionPlacesFragment
}
