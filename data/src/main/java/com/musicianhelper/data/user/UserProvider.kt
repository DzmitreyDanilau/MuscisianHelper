package com.musicianhelper.data.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface UserProvider {

    /**
     * Emits user data starting with the current one.
     */
    @ExperimentalCoroutinesApi
    suspend fun user(): MutableStateFlow<UserModel?>

}

interface UserUpdater {
    fun updateUser(user: UserModel) : Flow<UserModel>
}

