package com.musicianhelper.data.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class UserRepository : UserProvider, UserUpdater {
    /**
     * Emits user data starting with the current one.
     */
    @ExperimentalCoroutinesApi
    override suspend fun user(): MutableStateFlow<UserModel?> {
        return MutableStateFlow(null)
    }

    override fun updateUser(user: UserModel): Flow<Result<UserModel>> {
        return flow {
            Result.success(user)
        }
    }
}