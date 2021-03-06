package com.salimisler.data.base

import com.orhanobut.logger.Logger
import com.salimisler.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.Exception

fun <T> networkCall(
    call: suspend () -> Response<T>,
): Flow<Resource<T>> = flow {
    val response = call.invoke()

    if (response.isSuccessful) {
        response.body()?.let {
            emit(Resource.success(it))
        }
    } else {
        emit(Resource.error(Exception(response.message()), null))
    }
}.flowOn(Dispatchers.IO).onStart {
    emit(Resource.loading())
}.catch {
    Logger.e(it.localizedMessage)
    emit(Resource.error(Exception(it)))
}

fun <T> listenDatabase(
    query: () -> Flow<T>
): Flow<Resource<T>> = flow {
    try {
        val result = query.invoke().map { Resource.success(it) }
        emitAll(result)
    } catch (e: Exception) {
        val error = e
        emit(Resource.error(error))
    }
}.flowOn(Dispatchers.IO).onStart {
    emit(Resource.loading())
}.catch {
    Logger.e(it.localizedMessage)
    emit(Resource.error(Exception(it)))
}

fun updateDatabase(
    query: suspend () -> Unit
) = flow {
    try {
        query.invoke()
        emit(Resource.success(Unit))
    } catch (e: Exception) {
        val error = e
        emit(Resource.error(error))
    }
}.flowOn(Dispatchers.IO).onStart {
    emit(Resource.loading())
}.catch {
    Logger.e(it.localizedMessage)
    emit(Resource.error(Exception(it)))
}