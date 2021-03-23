package com.musicianhelper.domain.base

import kotlinx.coroutines.flow.Flow

interface UseCase<Action> {
   suspend fun invoke(action: Action): Flow<Result>
}

interface FlowTransformer<Upstream, Downstream> {

    fun apply(upstream: Flow<Upstream>): Flow<Downstream>

}
