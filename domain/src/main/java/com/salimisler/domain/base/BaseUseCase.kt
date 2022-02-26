package com.salimisler.domain.base

import com.salimisler.common.Resource
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase <T, A> {
    abstract fun invoke(params: T): Flow<Resource<A>>
}