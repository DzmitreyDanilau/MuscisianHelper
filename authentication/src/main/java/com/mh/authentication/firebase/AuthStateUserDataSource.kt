package com.mh.authentication.firebase

import com.musicianhelper.domain.base.Result
import kotlinx.coroutines.flow.Flow

/**
 * Listens to an Authentication state data source that emits updates on the current user.
 *
 * @see FirebaseAuthStateUserDataSource
 */
interface AuthStateUserDataSource {
    /**
     * Returns an observable of the [AuthenticatedUserInfoBasic].
     */
    fun getBasicUserInfo(): Flow<Result<AuthenticatedUserInfoBasic?>>
}
