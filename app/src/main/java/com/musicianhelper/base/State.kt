package com.musicianhelper.base

interface State<SR : StateRenderer> {

    fun accept(stateRenderer: SR)
}
