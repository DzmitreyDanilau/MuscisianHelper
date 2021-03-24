package com.musicianhelper.domain.base

import kotlinx.coroutines.flow.Flow

interface UseCase<Action, Result> {

    suspend fun invoke(action: Action): Flow<Result>

}
