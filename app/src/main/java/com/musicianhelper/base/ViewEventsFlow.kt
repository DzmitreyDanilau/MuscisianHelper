package com.musicianhelper.base

import kotlinx.coroutines.flow.Flow

/**
 * This allows us to group all the viewEvents from
 * one view in a single source.
 */
interface ViewEventFlow<E> {
    fun viewEvents(): Flow<E>
}