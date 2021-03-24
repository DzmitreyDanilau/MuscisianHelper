package com.musicianhelper.domain.auth

import kotlinx.coroutines.flow.SharedFlow

interface Authentication {

    val authResult: SharedFlow<AuthResult>

    fun register()

    suspend fun login()
}
