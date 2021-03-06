package com.musicianhelper.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

interface UseCase<A : Action, R : Result> : FlowCollector<A>

interface FlowTransformer<Upstream, Downstream> {

    fun apply(upstream: Flow<Upstream>): Flow<Downstream>

}
