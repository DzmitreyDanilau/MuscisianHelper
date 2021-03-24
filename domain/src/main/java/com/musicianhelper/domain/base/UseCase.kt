package com.musicianhelper.domain.base

interface UseCase<Action, Result> {

    suspend fun invoke(action: Action): Result

}
