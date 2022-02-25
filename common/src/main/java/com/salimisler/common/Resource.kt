package com.salimisler.common

import java.lang.Exception

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: Exception?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: Exception?, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    override fun toString(): String {
        return when (status) {
            Status.SUCCESS -> "Status: SUCCESS, DATA: ${data.toString()}"
            Status.LOADING -> "Status: LOADING"
            Status.ERROR -> "Status: ERROR!, MESSAGE: ${message.toString()}"
        }
    }
}