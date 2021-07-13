package com.musicianhelper.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musicianhelper.domain.base.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
abstract class BaseViewModel<SR : StateRenderer, S : State<SR>>(
    private val dispatcher: CoroutineDispatcher,
    private val initialState: S
) : ViewModel() {

    protected val event = MutableSharedFlow<Event>()

    protected val statePublisher: MutableStateFlow<S> = MutableStateFlow(initialState)

    protected val navigatorEmitter: MutableSharedFlow<Navigation> = MutableSharedFlow()

    protected fun handleEvents(sharedFlow: SharedFlow<Event>) {
        viewModelScope.launch {
            sharedFlow.collect {
                fireUseCase(it)
            }
        }
    }

    protected abstract fun fireUseCase(event: Event)
}
