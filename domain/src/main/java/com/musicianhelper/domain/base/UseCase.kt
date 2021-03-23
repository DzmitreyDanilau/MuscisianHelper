package com.musicianhelper.domain.base

import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun invoke(): Flow<Result>
}

interface FlowTransformer<Upstream, Downstream> {

    fun apply(upstream: Flow<Upstream>): Flow<Downstream>

}
