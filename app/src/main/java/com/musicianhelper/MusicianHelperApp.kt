package com.musicianhelper

import com.musicianhelper.di.components.DaggerMuzHelperComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MusicianHelperApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<MusicianHelperApp> {
      return  DaggerMuzHelperComponent.factory().create(this)
    }

}
