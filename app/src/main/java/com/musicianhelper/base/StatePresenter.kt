package com.musicianhelper.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface StatePresenter<SR : StateRenderer, S : State<SR>> {

    fun state(eventObservable: MutableStateFlow<Event>): MutableStateFlow<S>
}