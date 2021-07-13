package com.musicianhelper.extensions

import kotlinx.coroutines.channels.SendChannel

/**
 * Tries to send an element to a Channel and ignores the exception.
 */
fun <E> SendChannel<E>.trySend(element: E): Boolean = try {
    trySend(element).isSuccess
} catch (t: Throwable) {
    false // Ignore
}