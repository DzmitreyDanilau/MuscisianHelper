package com.musicianhelper.base

import kotlinx.coroutines.flow.MutableSharedFlow

interface StatePresenter<SR : StateRenderer, S : State<SR>> {

    fun state(eventObservable: MutableSharedFlow<Event>): MutableSharedFlow<S>
}