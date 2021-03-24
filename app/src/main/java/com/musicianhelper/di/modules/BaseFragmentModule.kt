package com.musicianhelper.di.modules

import androidx.fragment.app.Fragment
import com.musicianhelper.base.BaseFragment
import com.musicianhelper.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
abstract class BaseFragmentModule<T : BaseFragment> {

    @Provides
    @FragmentScope
    fun provideFragment(fragment: T): Fragment {
        return fragment
    }
}