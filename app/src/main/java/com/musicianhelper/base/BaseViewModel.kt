package com.musicianhelper.base

import androidx.lifecycle.ViewModel
import com.musicianhelper.domain.base.Action
import com.musicianhelper.domain.base.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseViewModel<S>(
    private val dispatcher: DispatchProvider,
    private val initialState: S
) : ViewModel() {

    private val TAG = BaseViewModel::class.java.simpleName
    private val viewState: MutableStateFlow<S> = MutableStateFlow(initialState)
    private val actions: MutableSharedFlow<Action> = MutableSharedFlow()

    protected fun getState(): StateFlow<S> = viewState

    private fun state() {

    }

    protected abstract fun processAction(action: Action): Flow<Result>

    protected fun reduceState(previous: S, result: Result): S {
        return previous
    }

    protected abstract suspend fun result(eventObservable: Flow<Event>): Flow<Result>
}
