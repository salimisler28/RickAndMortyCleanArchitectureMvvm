package com.salimisler.domain.base

abstract class BaseMapper<T, A> {
    abstract fun map(params: T): A
}