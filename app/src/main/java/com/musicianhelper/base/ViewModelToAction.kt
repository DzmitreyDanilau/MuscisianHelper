package com.musicianhelper.base

import com.musicianhelper.domain.base.Action

interface ViewModelToAction {
    fun onAction(action: Action)
}